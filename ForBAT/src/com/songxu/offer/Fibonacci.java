package com.songxu.offer;

/**
 * 递归与非递归的斐波那契数列求法
 * @author songxu
 *
 */
public class Fibonacci {
	/**
	 * 递归的写法
	 * @param n
	 * @return
	 */
	public int fibonacci(int n)
	{
		if(n<0)
		{
			return -1;
		}
		else {
			if(n ==0)
			{
				return 0;
			}
			if(n==1)
			{
				return 1;
			}
			return fibonacci(n-1)+fibonacci(n-2);
			
		}
	}
	
	public int fibonacci_new(int n)
	{
		
		if(n<0)
		{
			return -1;
		}
		if(n ==0)
		{
			return 0;
		}
		if(n==1)
		{
			return 1;
		}
		int last2=0;
		int last1=1;
		int now=0;
		for(int i=2;i<=n;i++)
		{
			now=last1+last2;
			last2=last1;
			last1=now;
		}
		return now;
		
		
		
	}
	public static void main(String[] args) {
		Fibonacci fibonacci=new Fibonacci();
		System.out.println(System.currentTimeMillis());
		fibonacci.fibonacci(50);
		System.out.println(System.currentTimeMillis());
		fibonacci.fibonacci_new(50);
		System.out.println(System.currentTimeMillis());
	}

}
