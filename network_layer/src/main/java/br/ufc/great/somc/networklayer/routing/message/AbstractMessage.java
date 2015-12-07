package br.ufc.great.somc.networklayer.routing.message;

public abstract class AbstractMessage {

	public String getType()
	{
		return this.getClass().getCanonicalName();
	}
}
