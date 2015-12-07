package br.ufc.great.somc.networklayer.routing.aodv;

import br.ufc.great.somc.networklayer.routing.RoutingEventsNotifier;

public interface AODVEventsNotifier extends RoutingEventsNotifier {
	
	void notifyAboutDestinationUnreachable(String destinationAddress);
	void notifyAboutInvalidRouteTo(String destinationAddress);
	
}
