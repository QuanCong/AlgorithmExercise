package com.songxu.multithread;

import java.util.Date;

/**
 * join���÷�
 * @author songxu
 *
 */
public class Join {
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread=new Thread(new JoinThread());
		System.out.println(System.currentTimeMillis()+":����ʼ����");
		thread.start();
		thread.join();//join�൱�������̵߳ȴ�thread���н������ټ���ִ��
		
		System.out.println(System.currentTimeMillis()+":���߳�����");
		
	}

}



class JoinThread implements Runnable
{

	@Override
	public void run() 
	{
		try {
			Thread.sleep(1000);
			System.out.println(System.currentTimeMillis()+":join�߳����н���");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}