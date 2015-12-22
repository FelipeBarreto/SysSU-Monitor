package br.ufc.great.iot.networklayer.device;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by witalobenicio on 02/03/15.
 */
public class Device{

    private HashMap<Tech, String> addresses;

    private String name;

    private static UUID uuid;

    public Device() {
        addresses = new HashMap<Tech, String>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        Device.uuid = uuid;
    }

    public HashMap<Tech, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(HashMap<Tech, String> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBestAddress(){
        String bestAddress;

        if (addresses.containsKey(Tech.BLUETOOTH)){
            bestAddress = addresses.get(Tech.BLUETOOTH);
            return bestAddress;
        }else if (addresses.containsKey(Tech.WIFIDIRECT)){
            bestAddress = addresses.get(Tech.WIFIDIRECT);
            return bestAddress;
        }else if (addresses.containsKey(Tech.WIFI)){
            bestAddress = addresses.get(Tech.WIFI);
            return bestAddress;
        }else if (addresses.containsKey(Tech.GSM)){
            bestAddress = addresses.get(Tech.GSM);
            return bestAddress;
        }else if (addresses.containsKey(Tech.OTHER)){
            bestAddress = addresses.get(Tech.OTHER);
            return bestAddress;
        }

        return null;
    }

}
