package br.ufc.great.iot.networklayer.routing.aodv.message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.UUID;

import br.ufc.great.iot.networklayer.device.Device;
import br.ufc.great.iot.networklayer.device.RemoteDevicesManager;

public class RouteError extends AODVMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -794723904537378260L;

	private int unreachableNodeSequenceNumber;
	private Device unreachableNodeAddress;
	private ArrayList<Device> unreachableDestAdderss = new ArrayList<Device>();

	private static final String UNREACHABLE_NUMBER = "unreachableNodeSequenceNumber";
	private static final String UNREACHABLE_ADDRESS = "unreachableNodeAddress";
	private static final String ARRAY_UNREACHABLE = "unreachableDestAdderss";
	private static final String HOP_COUNT = "hopCount";
	
	public RouteError() {
	}
	
	
	public RouteError(Device unreachableNodeAddress, int unreachableNodeSequenceNumber,
			ArrayList<Device> unreachableDestAdderss) {
		this.unreachableNodeSequenceNumber = unreachableNodeSequenceNumber;
		this.unreachableNodeAddress = unreachableNodeAddress;
		this.unreachableDestAdderss = unreachableDestAdderss;
		setDestinationAddress(RemoteDevicesManager.getInstance().getCustomDevice("-1"));
	}




    public RouteError(Device unreachableNodeAddress, int unreachableNodeSequenceNumber,
			Device destinationAddress) {
		this.unreachableNodeSequenceNumber = unreachableNodeSequenceNumber;
		this.unreachableNodeAddress = unreachableNodeAddress;
		setDestinationAddress(destinationAddress);
	
	}
	
	@Override
	public AODV_MESSAGE_TYPE getMessageType() {
		return AODV_MESSAGE_TYPE.RRER;
	}



	public int getUnreachableNodeSequenceNumber() {
		return unreachableNodeSequenceNumber;
	}



	public void setUnreachableNodeSequenceNumber(int unreachableNodeSequenceNumber) {
		this.unreachableNodeSequenceNumber = unreachableNodeSequenceNumber;
	}



	public Device getUnreachableNodeAddress() {
		return unreachableNodeAddress;
	}



	public void setUnreachableNodeAddress(Device unreachableNodeAddress) {
		this.unreachableNodeAddress = unreachableNodeAddress;
	}



	public ArrayList<Device> getUnreachableDestAdderss() {
		return unreachableDestAdderss;
	}



	public void setUnreachableDestAdderss(ArrayList<Device> unreachableDestAdderss) {
		this.unreachableDestAdderss = unreachableDestAdderss;
	}
	
	@Override
	protected JSONObject toJsonObject(JSONObject json) {
		super.toJsonObject(json);
		try {
			json.put(HOP_COUNT, getHopCount());
			json.put(UNREACHABLE_NUMBER, unreachableNodeSequenceNumber);
			json.put(UNREACHABLE_ADDRESS, unreachableNodeAddress);
			json.put(ARRAY_UNREACHABLE, new JSONArray(unreachableDestAdderss));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	@Override
	protected void instanceFromJson(JSONObject json) {
		super.instanceFromJson(json);
		setHopCount(json.optInt(HOP_COUNT, -1));
		unreachableNodeSequenceNumber = json.optInt(UNREACHABLE_NUMBER, -1);
		unreachableNodeAddress.setUuid(UUID.fromString(json.optString(UNREACHABLE_ADDRESS, null)));
		JSONArray pathArray = json.optJSONArray(ARRAY_UNREACHABLE);
		for(int i = 0; i < pathArray.length(); i++)
		{
			unreachableDestAdderss.add(RemoteDevicesManager.getInstance().getCustomDevice(pathArray.optString(i, null)));
		}		
	}
}
