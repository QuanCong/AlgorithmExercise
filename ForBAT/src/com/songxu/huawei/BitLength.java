package com.songxu.huawei;

import java.util.Scanner;
/**
 * ��int���������ڴ��д洢ʱ1�ĸ���
 * 
 * ����һ��������int���ͣ�
 * �����ת����2���ƺ����1�ĸ���
 * @author songxu
 *
 */
public class BitLength {

	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			int input=scanner.nextInt();
			int mark=1;
			int count=0;
			for(int i=1;i<=32;i++)
			{
				if((input&mark)==mark)
				{
					count++;
				}
				mark=mark<<1;
				
			}
			System.out.println(count);
			
			
			
		}
		
		
		
		
		
	}

}
