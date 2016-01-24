package com.songxu.multithread;

public class ThreadLocalLearn 
{
	ThreadLocal<Integer> threadLocal_Integer=new ThreadLocal<>();
	public void setValue()
	{
		threadLocal_Integer.set(1);
	}

}
