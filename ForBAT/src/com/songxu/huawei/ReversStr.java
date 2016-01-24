package com.songxu.huawei;

import java.util.Scanner;
/**
 * ·´×ª×Ö·û´®
 * @author songxu
 *
 */
public class ReversStr {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			String inputNum=scanner.next();
			
			char []chars=inputNum.toCharArray();
			StringBuilder builder=new StringBuilder();
			for(int i=chars.length-1;i>=0;i--)
			{
				builder.append(chars[i]);
			}
			System.out.println(builder.toString());
			
			
			
			
			
			
		}
		
		
		
		
		
	}
}
