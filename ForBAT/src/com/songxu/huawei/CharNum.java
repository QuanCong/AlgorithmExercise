package com.songxu.huawei;

import java.util.Scanner;
/**
 * 
题目描述

编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。

输入描述:

输入N个字符，字符在ACSII码范围内(0~127)。



输出描述:

输出字符的个数。


输入例子:

abc


输出例子:

3


 * @author songxu
 *
 */
public class CharNum {
	
	
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			String input=scanner.next();
			char []chars=input.toCharArray();
			int []counter=new int[128];
			int count=0;
			for(int i=0;i<chars.length;i++)
			{
				if(chars[i]<128&&counter[chars[i]]==0)
				{
					counter[chars[i]]++;
					count++;
				}
			}
			System.out.println(count);
			
			
			
		}
		
		
	}

}
