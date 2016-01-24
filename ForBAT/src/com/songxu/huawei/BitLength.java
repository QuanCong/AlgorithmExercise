package com.songxu.huawei;

import java.util.Scanner;
/**
 * 求int型数据在内存中存储时1的个数
 * 
 * 输入一个整数（int类型）
 * 这个数转换成2进制后，输出1的个数
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
