package br.ufc.great.iot.networklayer.base;

import br.ufc.great.iot.networklayer.device.Device;

public interface CommunicableEventListener {

    void onDeviceFound(String name, String address);

    void onDeviceConnect(Device device);

    void onDeviceDisconnect(Device device);

    void onExceptionOcurred(int code, String message);

    void updateNeighboorList(Device device, String canonicalName);

    void onActiveNetwork(String myAddresses);

    void onDesactiveNetwork(String myAddress);

}
