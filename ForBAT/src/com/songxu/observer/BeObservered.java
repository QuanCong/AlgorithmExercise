package com.songxu.observer;

public interface BeObservered {
	/**
	 * ע��۲���
	 * @param observer
	 */
	public void regist(Observer observer);
	/**
	 * �Ƴ��۲���
	 * @param observer
	 */
	public void remove(Observer observer);
	/**
	 * ֪ͨ���й۲���
	 */
	public void notifyAllObserver(Object value);

}
