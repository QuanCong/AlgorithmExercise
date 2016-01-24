package com.songxu.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �̳߳���ʾ
 * @author songxu
 *
 */
public class ThreadPoolLearn {
	
	static BlockingQueue blockingQueue=new ArrayBlockingQueue<>(1);
	
	static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10, 20, 1, TimeUnit.MINUTES, blockingQueue);
	/**
	 * �жϲ���
	 */
	public static void  test1()
	{
		for(int i=0;i<10;i++)
		{
			Runnable runnable=new TaskWithoutResult(1000);
			threadPoolExecutor.submit(runnable);
		}
		threadPoolExecutor.shutdown();//���ᴥ���ж�
		threadPoolExecutor.shutdownNow();//�ᴥ���ж�
	}
	/**
	 * ���ݲ���
	 */
	public static void  test2()
	{
		for(int i=0;i<20;i++)
		{
			Runnable runnable=new TaskBusyWithoutResult();
			threadPoolExecutor.submit(runnable);
		}
	}
	public static void main(String[] args) throws InterruptedException
	{
		
		//test1();
		//test2 ���ݲ���
		
		Thread.sleep(10000);
		
		test2();
	
	}
	

}
/**
 * �з���ֵ������
 * @author songxu
 *
 */
class TaskWithResult implements Callable<Boolean>
{
	private int sleepTime=1000;//Ĭ��˯��ʱ��1s
	public TaskWithResult(int sleepTime)
	{
		this.sleepTime=sleepTime;
	}
	@Override
	public Boolean call() throws Exception 
	{
		
		System.out.println("�߳�"+Thread.currentThread()+"��ʼ����");
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			
			System.out.println("�߳�"+Thread.currentThread()+"���ж�");
			return false;
		}
		System.out.println("�߳�"+Thread.currentThread()+"��������");
		
		return true;
	}
	
}
/**
 * �޷���ֵ������
 * @author songxu
 *
 */
class TaskWithoutResult implements Runnable
{
	private int sleepTime=1000;//Ĭ��˯��ʱ��1s
	public TaskWithoutResult(int sleepTime)
	{
		this.sleepTime=sleepTime;
	}
	@Override
	public void run() 
	{
		System.out.println("�߳�"+Thread.currentThread()+"��ʼ����");
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			
			System.out.println("�߳�"+Thread.currentThread()+"���ж�");
		}
		System.out.println("�߳�"+Thread.currentThread()+"��������");
	}
	


}
/**
 * ��æ������
 * @author songxu
 *
 */
class TaskBusyWithoutResult implements Runnable
{
	public TaskBusyWithoutResult()
	{
	}
	@Override
	public void run() 
	{
		System.out.println("�߳�"+Thread.currentThread()+"��ʼ����");
		int i=10000*10000;
		while(i>0)
		{
			i--;
		}
		System.out.println("�߳�"+Thread.currentThread()+"���н���");
	}
	


}