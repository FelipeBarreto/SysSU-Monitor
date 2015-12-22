package br.ufc.great.iot.networklayer.routing.aodv;

import br.ufc.great.iot.networklayer.device.Device;
import br.ufc.great.iot.networklayer.routing.RoutingEventsNotifier;

public interface AODVEventsNotifier extends RoutingEventsNotifier {
	
	void notifyAboutDestinationUnreachable(Device destinationAddress);
	void notifyAboutInvalidRouteTo(Device destinationAddress);
	
}
