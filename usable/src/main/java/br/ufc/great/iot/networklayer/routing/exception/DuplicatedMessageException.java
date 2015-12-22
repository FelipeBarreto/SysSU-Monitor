package br.ufc.great.iot.networklayer.routing.exception;


import br.ufc.great.iot.networklayer.device.Device;

public class DuplicatedMessageException extends RoutingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3832519844427982407L;
	private String exceptionMessage;
	
	public DuplicatedMessageException(Device sourceAddress, int sequenceNumber) {
		
		exceptionMessage = "DuplicateMessageReceived Source Address : "+ sourceAddress +
				" Source Sequence Number :" + sequenceNumber;
	}

	@Override
	public String toString() {
		return exceptionMessage;
	}
}
