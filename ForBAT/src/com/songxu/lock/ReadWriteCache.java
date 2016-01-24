package com.songxu.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * ���ö�д��ʵ�ֵ�һ�����ݽṹ
 * @author songxu
 *
 */
public class ReadWriteCache 
{
	//����hashmap��Ϊ�ײ����ݽṹ
	private Map<String, Object> cache=new HashMap<String, Object>();
	//�����д��
	private ReentrantReadWriteLock readwritelock=new ReentrantReadWriteLock();
	//����
	private Lock readLock=readwritelock.readLock();
	//д��
	private Lock writeLock=readwritelock.writeLock();
	
	/**
	 * ��������
	 * @param key  ��
	 * @param value ֵ
	 */
	public void put(String key,Object value)
	{
		writeLock.lock();
		//��һ����try��֮��
		try {
			cache.put(key, value);
		} 
		finally
		{
			writeLock.unlock();
		}
	}
	/**
	 * ��ȡ����
	 * @param key ��
	 * @return  ֵ
	 */
	public Object get(String key)
	{
		readLock.lock();
		try {
			return cache.get(key);
		} 
		finally
		{
			readLock.unlock();
		}
	}

}
