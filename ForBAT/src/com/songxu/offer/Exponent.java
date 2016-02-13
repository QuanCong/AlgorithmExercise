package com.songxu.offer;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
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
	 * �������� һ������0����exponent����
	 * 
	 * a^n= a^(n/2)*a^(n/2) nΪż��
	 * a^n=a^(n/2)*a^(n/2)*a nλ����
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
		result=assist(base, exponent>>1);//������λ�������
		result*=result;
		if((exponent&0x1)==1)//�ж�һ�����Ƿ�Ϊ����
		{
			result=base*result;//ָ��Ϊ����������һ��base
		}
		return result;
	}
	public static void main(String[] args) {
		Exponent exponent=new Exponent();
		
		System.out.println(exponent.Power(0, 0));
	}

}
