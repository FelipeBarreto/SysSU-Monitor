package br.ufc.great.iot.networklayer.routing.flooding;

import br.ufc.great.iot.networklayer.device.Device;

public class MessageEntry {
	
	private Device sourceAddress;
	private int sequenceNumber;
	private long timeStamp;
	
	public MessageEntry(Device sourceAddress, int sequenceNumber) {
		super();
		this.sourceAddress = sourceAddress;
		this.sequenceNumber = sequenceNumber;
		timeStamp = System.currentTimeMillis();
	}	 
	
	public Device getSourceAddress() {
		return sourceAddress;
	}
	
	public void setSourceAddress(Device sourceAddress) {
		this.sourceAddress = sourceAddress;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	public long getTimeStamp()
	{
		return timeStamp;
	}
	
	@Override
	public boolean equals(Object o) {
		MessageEntry msg = ((MessageEntry) o);
		if(msg.getSequenceNumber() == this.getSequenceNumber() && 
				msg.getSourceAddress().getUuid().compareTo(getSourceAddress().getUuid())==0)
		{
			return true;
		}		
		return false; 
	}
}
