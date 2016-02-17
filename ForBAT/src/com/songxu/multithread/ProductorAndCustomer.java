package com.songxu.multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * ʵ��һ�������� ����������
 * @author songxu
 *
 */
public class ProductorAndCustomer {
	
	public static void main(String[] args) {
		
		Queue<Integer> queue=new LinkedList<Integer>();
		Thread pThread=new Thread(new Productor(queue));
		Thread cThread=new Thread(new Customer(queue));
		
		pThread.start();
		cThread.start();
		
		
		
	}
}
/**
 * ��Ҫע�������
 * 1 wait notify notifyAll �����������synchronizedͬ������
 * 2 �ж� notify ����Ҫ����ѭ���� ��������if��
 * ��Ϊֻ���������ܱ�֤�߳��ڻ��CPU���Ȼ��Ѻ��ٴ�ȥ��������Ƿ����
 * 3 ����ʹ��notifyAll�������notify����
 * 4 synchronized��ס�Ķ���Ӧ���������̹߳���Ķ��� �ڱ�����Ϊ�����߶���
 * 
 * 
 * 
 * 
 * 
 */



/**
 * �������߳�
 * @author songxu
 *
 */
class Productor implements Runnable
{
	//�������
	private final static int MAXSIZE=10;
	
	private Queue<Integer> queue;
	
	public Productor(Queue<Integer> queue)
	{
		this.queue=queue;
	}

	@Override
	public void run() {
		
		System.out.println("�������߳̿�ʼ����");
		System.out.println("==============");
		while(true)
		{
			synchronized (queue) {
				while(queue.size()<MAXSIZE)
				{
					Random random=new Random();
					int num=random.nextInt();
					queue.add(num);
					System.out.println("������������һ����Ʒ��"+num);
					queue.notifyAll();
				}
				try {
					System.out.println("��������");
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
	}

}


class Customer implements Runnable
{

	private Queue<Integer> queue;
	public Customer(Queue<Integer> queue)
	{
		this.queue=queue;
	}
	
	@Override
	public void run() {
		
		System.out.println("�������߳̿�ʼ����");
		System.out.println("==============");
		while(true)
		{
			synchronized (queue) {
			
				while(!queue.isEmpty())
				{
					System.out.println("�����������˲�Ʒ��"+queue.remove());
					queue.notifyAll();
				}
				try {
					System.out.println("�����ѿ�");
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	







}