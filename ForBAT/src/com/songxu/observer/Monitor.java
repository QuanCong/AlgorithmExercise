package com.songxu.observer;

public class Monitor implements Observer {

	private String name="monitor";
	public Monitor(String name)
	{
		this.name=name;
	}
	@Override
	public void notify(BeObservered observered, Object value) {
		
		System.out.println(name+" ’µΩº‡≤‚÷µ£∫"+value);
		
	}

}
