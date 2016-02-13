package com.songxu.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author songxu
 *
 */
public class Exponent {
	
	public double Power(double base, int exponent) {
		
		
		if(exponent>=0)
		{
			return assist(base, exponent);
		}
		else {
			return 1/assist(base, (-1)*exponent);
		}
		
		
		
		
        
	  }
	/**
	 * 辅助计算 一个大于0的数exponent的幂
	 * 
	 * a^n= a^(n/2)*a^(n/2) n为偶数
	 * a^n=a^(n/2)*a^(n/2)*a n位奇数
	 * @param base
	 * @param exponent
	 * @return
	 */
	private double assist(double base,int exponent)
	{
		if(exponent==0)
		{
			return 1;
		}
		if(exponent==1)
		{
			return base;
		}
		
		double result=0;
		result=assist(base, exponent>>1);//利用移位代替除二
		result*=result;
		if((exponent&0x1)==1)//判断一个数是否为奇数
		{
			result=base*result;//指数为奇数，则多乘一个base
		}
		return result;
	}
	public static void main(String[] args) {
		Exponent exponent=new Exponent();
		
		System.out.println(exponent.Power(0, 0));
	}

}
