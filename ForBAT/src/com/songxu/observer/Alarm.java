package com.songxu.observer;

import java.util.ArrayList;
import java.util.List;

public class Alarm implements BeObservered {

	private static final List<Observer> allObserver=new ArrayList<Observer>();
	
	
	@Override
	public void regist(Observer observer) {

		allObserver.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		allObserver.remove(observer);
	}

	@Override
	public void notifyAllObserver(Object value) {
		
		for (Observer observer : allObserver) {
			observer.notify(this, value);
		}
	}
	/**
	 * 做了某件事而触发观察者
	 */
	public void doSomething()
	{
		notifyAllObserver("做了某件事");
	}

}
