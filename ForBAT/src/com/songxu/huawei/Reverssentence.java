package com.songxu.huawei;

import java.util.Scanner;
/**
 * ·´×ª×Ö·û´®
 * @author songxu
 *
 */
public class Reverssentence {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			String inputNum=scanner.nextLine();
			
			String []words=inputNum.split(" ");
			StringBuilder builder=new StringBuilder();
			for(int i=words.length-1;i>=0;i--)
			{
				builder.append(words[i]+" ");
			}
			System.out.println(builder.toString());
			
			
			
			
			
			
		}
		
		
		
		
		
	}
}
