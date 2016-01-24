package com.songxu.multithread;

import java.util.Date;

/**
 * join的用法
 * @author songxu
 *
 */
public class Join {
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread=new Thread(new JoinThread());
		System.out.println(System.currentTimeMillis()+":程序开始运行");
		thread.start();
		thread.join();//join相当于让主线程等待thread运行结束后再继续执行
		
		System.out.println(System.currentTimeMillis()+":主线程运行");
		
	}

}



class JoinThread implements Runnable
{

	@Override
	public void run() 
	{
		try {
			Thread.sleep(1000);
			System.out.println(System.currentTimeMillis()+":join线程运行结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}