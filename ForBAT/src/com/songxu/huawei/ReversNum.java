package com.songxu.huawei;

import java.util.Scanner;
/**
 * 描述：

输入一个整数，将这个整数以字符串的形式逆序输出

程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001

 
 * @author songxu
 *
 */
public class ReversNum {
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			int inputNum=scanner.nextInt();
			
			char []chars=Integer.toString(inputNum).toCharArray();
			StringBuilder builder=new StringBuilder();
			for(int i=chars.length-1;i>=0;i--)
			{
				builder.append(chars[i]);
			}
			System.out.println(builder.toString());
			
			
			
			
			
			
		}
		
		
		
		
		
	}

}
