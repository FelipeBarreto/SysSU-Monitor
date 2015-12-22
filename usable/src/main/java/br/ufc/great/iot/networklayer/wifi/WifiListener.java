package br.ufc.great.iot.networklayer.wifi;

public interface WifiListener {

	void onMesssageReceived(String deviceAddress, String message);

	void onDeviceConnected(String uuid, String sourceAddress);

	void onDeviceDisconnected(String uuid, String sourceIpAddress);

}
