package com.songxu.observer;

public interface BeObservered {
	/**
	 * 注册观察者
	 * @param observer
	 */
	public void regist(Observer observer);
	/**
	 * 移除观察者
	 * @param observer
	 */
	public void remove(Observer observer);
	/**
	 * 通知所有观察者
	 */
	public void notifyAllObserver(Object value);

}
