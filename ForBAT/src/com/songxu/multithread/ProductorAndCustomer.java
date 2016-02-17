package com.songxu.multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 实现一个生产者 消费者问题
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
 * 需要注意的问题
 * 1 wait notify notifyAll 方法必须放在synchronized同步块中
 * 2 判断 notify 条件要放在循环中 而不是在if中
 * 因为只有这样才能保证线程在获得CPU调度唤醒后再次去检查条件是否符合
 * 3 尽量使用notifyAll方法替代notify方法
 * 4 synchronized锁住的对象应该是两个线程共享的对象 在本例中为消费者队列
 * 
 * 
 * 
 * 
 * 
 */



/**
 * 生产者线程
 * @author songxu
 *
 */
class Productor implements Runnable
{
	//最大容量
	private final static int MAXSIZE=10;
	
	private Queue<Integer> queue;
	
	public Productor(Queue<Integer> queue)
	{
		this.queue=queue;
	}

	@Override
	public void run() {
		
		System.out.println("生产者线程开始工作");
		System.out.println("==============");
		while(true)
		{
			synchronized (queue) {
				while(queue.size()<MAXSIZE)
				{
					Random random=new Random();
					int num=random.nextInt();
					queue.add(num);
					System.out.println("生产者生产了一个产品："+num);
					queue.notifyAll();
				}
				try {
					System.out.println("队列已满");
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
		
		System.out.println("消费者线程开始工作");
		System.out.println("==============");
		while(true)
		{
			synchronized (queue) {
			
				while(!queue.isEmpty())
				{
					System.out.println("消费者消耗了产品："+queue.remove());
					queue.notifyAll();
				}
				try {
					System.out.println("队列已空");
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	







}