package br.ufc.great.iot.networklayer.base;

import android.content.Context;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import br.ufc.great.iot.networklayer.device.Device;
import br.ufc.great.iot.networklayer.device.RemoteDevicesManager;
import br.ufc.great.iot.networklayer.device.UUIDFactory;
import br.ufc.great.iot.networklayer.exception.AddressNotDefinedException;
import br.ufc.great.iot.networklayer.exception.NoActiveNetworkException;
import br.ufc.great.iot.networklayer.routing.IRouter;
import br.ufc.great.iot.networklayer.routing.message.RoutingMessage;
import br.ufc.great.iot.networklayer.util.Simulation;

public class NetworkContainer {

	private HashMap<String, Communicable> container;

	private String applicationID;
	private static NetworkContainer networkContainer;

	// TODO: remover
	private Simulation simulation;

	private NetworkContainer() {
		container = new HashMap<String, Communicable>();
		simulation = Simulation.getInstance();
	}

	public static NetworkContainer getInstance() {
		if (networkContainer == null) {
			networkContainer = new NetworkContainer();
		}
		return networkContainer;
	}

	public <T> Communicable addNewNetwork(Class<T> className, Context context,
			CommunicableEventListener notifier,
			MessageEventListener messageNotifier) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Constructor<T> c = className.getConstructor(Context.class,
				CommunicableEventListener.class, MessageEventListener.class);
		Communicable network = (Communicable) c.newInstance(context, notifier,
				messageNotifier);
		addNetwork(network);
		return network;
	}

	public void addNetwork(Communicable network) {
		container.put(network.getClass().getCanonicalName(), network);
	}

	public void activeNetworks() {
		Set<String> networks = container.keySet();
		Iterator<String> it = networks.iterator();
		String active = null;
		while (it.hasNext()) {
			active = it.next();
			container.get(active).onStart();
		}
	}

	public void disableNetworks() {
		Set<String> networks = container.keySet();
		Iterator<String> it = networks.iterator();
		String active = null;
		while (it.hasNext()) {
			active = it.next();
			if ( container.get(active).isActive() ) {
				container.get(active).onStop();
			}
		}
	}

	private boolean hasActiveNetwork(Collection<Communicable> networks)
			throws NoActiveNetworkException {
		if (networks.size() == 0) {
			throw new NoActiveNetworkException();
		}
		return true;
	}

	public void setApplicationID(String appID) {
		this.applicationID = appID;
	}

	private void updateRoutingMessage(Communicable network,
			RoutingMessage routingMsg) throws AddressNotDefinedException {
		Device myDevice = RemoteDevicesManager.getInstance().getCustomDevice(network.getMyAddress());
        myDevice.setUuid(UUIDFactory.getDeviceUuid());
//		address = network.getMyAddress();
//        address = UUIDFactory.getDeviceUuid().to;

		if(routingMsg.getApplicationID() == null)
		{
			routingMsg.setApplicationID(applicationID);
		}
		if (routingMsg.getSourceAddress() == null) {
			routingMsg.setSourceAddress(myDevice);
		}
		routingMsg.setPreviousHop(myDevice);

		if (NetworkManager.SIMULATION) {
			routingMsg.incrementHops();
			simulation.log(routingMsg, true);
		}

	}

	public boolean sendMessage(RoutingMessage routingMsg)
			throws NoActiveNetworkException {

		if (routingMsg.getNextHop().getUuid().compareTo(UUID.fromString(IRouter.BROADCAST)) == 0
				|| routingMsg.getNextHop().getUuid().compareTo(UUID.fromString(IRouter.BROADCAST_EXCLUDING_SOURCE)) == 0) {
			return sendBroadcastMessage(routingMsg);
		} else {
			return sendUnicastMessage(routingMsg);
		}
	}

	public boolean sendBroadcastMessage(RoutingMessage routingMsg)
			throws NoActiveNetworkException {
		boolean success = true;
		Collection<Communicable> networks = container.values();

		if (hasActiveNetwork(networks)) {
			for (Communicable activeNetwork : networks) {
				if ( activeNetwork.isActive()) {
					Device avoidDevice = null;
					if (routingMsg.getNextHop().getUuid().compareTo(UUID.fromString(IRouter.BROADCAST_EXCLUDING_SOURCE))==0) {
						avoidDevice = routingMsg.getPreviousHop();
					}
	
					try {
						updateRoutingMessage(activeNetwork, routingMsg);
					} catch (AddressNotDefinedException e) {
						e.printStackTrace();
						success = false;
						return success;
					}
					success = success && activeNetwork.sendBroadcastMessage(RoutingMessage.toJson(routingMsg),avoidDevice.getBestAddress());
				}
			}
			return success;
		}
		return false;
	}

	public boolean sendUnicastMessage(RoutingMessage routingMsg)
			throws NoActiveNetworkException {
		Collection<Communicable> networks = container.values();

		if (hasActiveNetwork(networks)) {

			for (Communicable activeNetwork : networks) {
				if (activeNetwork != null) {
					if ( activeNetwork.isActive()) {
						try {
							updateRoutingMessage(activeNetwork, routingMsg);
						} catch (AddressNotDefinedException e) {
							e.printStackTrace();
							return false;
						}
						return activeNetwork.sendMessage(
								RoutingMessage.toJson(routingMsg),
								routingMsg.getNextHop().getBestAddress());
					}
				}
			}
		}

		return false;
	}

	public List<String> getMyAddresses() {
		Set<String> networks = container.keySet();
		List<String> myAddresses = new ArrayList<String>(networks.size());
		Iterator<String> it = networks.iterator();
		while (it.hasNext()) {
			Communicable activeNetwork = container.get(it.next());
			try {
				myAddresses.add(activeNetwork.getMyAddress());
			} catch (AddressNotDefinedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myAddresses;
	}

	public List<Communicable> getNetworkByMyAddresses(String myAddress) {
		Set<String> networks = container.keySet();
		List<Communicable> communicables = new ArrayList<Communicable>();
		Iterator<String> it = networks.iterator();
		while (it.hasNext()) {
			Communicable activeNetwork = container.get(it.next());
			try {
				if (myAddress.equalsIgnoreCase(activeNetwork.getMyAddress())) {
					communicables.add(activeNetwork);
				}
			} catch (AddressNotDefinedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (communicables.isEmpty())
			return null;
		return communicables;
	}

	public int size() {
		return container.size();
	}

}
