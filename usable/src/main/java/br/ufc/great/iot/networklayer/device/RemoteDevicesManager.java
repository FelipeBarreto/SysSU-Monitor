package br.ufc.great.iot.networklayer.device;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by great on 04/03/2015.
 */
public class RemoteDevicesManager {

    public static RemoteDevicesManager instance;

    private HashMap<String, Device> devices;

    private RemoteDevicesManager(){
        devices = new HashMap<String, Device>();
    }

    public static RemoteDevicesManager getInstance(){
        if(instance == null){
            instance = new RemoteDevicesManager();
        }
        return instance;
    }

    public Device getCustomDevice(String broadcastAddress){
        Device device = new Device();
        device.setName(broadcastAddress);
        device.setUuid(UUID.fromString(broadcastAddress));
        device.getAddresses().put(Tech.OTHER, broadcastAddress);
        return device;
    }

    public Device getDevice(UUID uuid){
        if(devices.containsKey(uuid.toString())){
            return devices.get(uuid.toString());
        }
        return null; // doesn't exist devices associated with this UUID.
    }

    public Device getDevice(String uuid){
        if(devices.containsKey(uuid)){
            return devices.get(uuid);
        }
        return null; // doesn't exist devices associated with this UUID.
    }

    public Device notifyNewConnection(Tech tech, String uuid, String name, String address){
        Device device;
        if(devices.containsKey(uuid)){
            device = getDevice(uuid);
            device.getAddresses().put(tech, address);
        }
        else{
            device = new Device();
            device.setName(name);
            device.setUuid(UUID.fromString(uuid));
            device.getAddresses().put(tech, address);
        }

        return device;
    }

    public void notifyDisconnection(Tech tech, String uuid){
        if(!devices.containsKey(uuid)){
            return; // Do nothing if there is no device with this uuid
        }
        Device device = devices.get(uuid);
        HashMap<Tech, String> addresses = device.getAddresses();
        if(!addresses.containsKey(tech)){
            return; // Do nothing if the connection do not exists
        }
        addresses.remove(tech);
        if(addresses.size() == 0){
            devices.remove(uuid); // Remove the Device if there is no active connection
        }
    }
}
