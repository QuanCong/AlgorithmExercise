package com.songxu.huawei;

import java.util.Scanner;
/**
 * ������

����һ��������������������ַ�������ʽ�������

���򲻿��Ǹ���������������ֺ���0����������ʽҲ����0��������Ϊ100�������Ϊ001

 
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
