package com.songxu.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * @author songxu
 *输入描述:
 *输入一个int型整数
 *输出描述:
 *按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *输入例子:
 *9876673
 *输出例子:
 *37689
 */
public class NoRepeatNum {
	
	public static int getNoRepeatNum(int input)
	{
		String inputStr=Integer.toString(input);
		char [] chars=inputStr.toCharArray();
		List<Integer> list=new ArrayList<Integer>();
		for(int i=chars.length-1;i>=0;i--)
		{
			
			int a=chars[i]-48;
			if(!list.contains(a))
			{
				list.add(a);
			}
			
			
		}
		StringBuilder sBuilder=new StringBuilder();
		for (Integer integer : list) {
			sBuilder.append(integer);
		}
		
		return new Integer(sBuilder.toString());
	
	
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int input=scanner.nextInt();
			
			System.out.println(getNoRepeatNum(input));
			
		}
	}
	

}
