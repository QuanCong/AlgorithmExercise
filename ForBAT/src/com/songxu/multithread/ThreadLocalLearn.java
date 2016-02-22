package com.songxu.multithread;

public class ThreadLocalLearn 
{
	ThreadLocal<Integer> threadLocal_Integer=new ThreadLocal<Integer>()
			{
				protected Integer initialValue() {
					return 0;
				};
				
			};
	public void setValue()
	{
		threadLocal_Integer.set(1);
		
	}
	

}
