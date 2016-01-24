package com.songxu.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池演示
 * @author songxu
 *
 */
public class ThreadPoolLearn {
	
	static BlockingQueue blockingQueue=new ArrayBlockingQueue<>(1);
	
	static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10, 20, 1, TimeUnit.MINUTES, blockingQueue);
	/**
	 * 中断测试
	 */
	public static void  test1()
	{
		for(int i=0;i<10;i++)
		{
			Runnable runnable=new TaskWithoutResult(1000);
			threadPoolExecutor.submit(runnable);
		}
		threadPoolExecutor.shutdown();//不会触发中断
		threadPoolExecutor.shutdownNow();//会触发中断
	}
	/**
	 * 扩容测试
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
		//test2 扩容测试
		
		Thread.sleep(10000);
		
		test2();
	
	}
	

}
/**
 * 有返回值的任务
 * @author songxu
 *
 */
class TaskWithResult implements Callable<Boolean>
{
	private int sleepTime=1000;//默认睡眠时间1s
	public TaskWithResult(int sleepTime)
	{
		this.sleepTime=sleepTime;
	}
	@Override
	public Boolean call() throws Exception 
	{
		
		System.out.println("线程"+Thread.currentThread()+"开始运行");
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			
			System.out.println("线程"+Thread.currentThread()+"被中断");
			return false;
		}
		System.out.println("线程"+Thread.currentThread()+"结束运行");
		
		return true;
	}
	
}
/**
 * 无返回值的任务
 * @author songxu
 *
 */
class TaskWithoutResult implements Runnable
{
	private int sleepTime=1000;//默认睡眠时间1s
	public TaskWithoutResult(int sleepTime)
	{
		this.sleepTime=sleepTime;
	}
	@Override
	public void run() 
	{
		System.out.println("线程"+Thread.currentThread()+"开始运行");
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			
			System.out.println("线程"+Thread.currentThread()+"被中断");
		}
		System.out.println("线程"+Thread.currentThread()+"结束运行");
	}
	


}
/**
 * 繁忙的任务
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
		System.out.println("线程"+Thread.currentThread()+"开始运行");
		int i=10000*10000;
		while(i>0)
		{
			i--;
		}
		System.out.println("线程"+Thread.currentThread()+"运行结束");
	}
	


}