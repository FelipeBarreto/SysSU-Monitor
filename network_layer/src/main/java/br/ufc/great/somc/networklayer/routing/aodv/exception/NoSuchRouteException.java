package br.ufc.great.somc.networklayer.routing.aodv.exception;

public class NoSuchRouteException extends AODVException {

	public NoSuchRouteException(String message) {
		super(message);
		
	}
	
	public NoSuchRouteException()
	{
		super("No such route Exception");
	}

}
