package com.songxu.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符， 然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 
 * @author songxu
 *
 */
public class CharCounter {

	
	public static void main(String[] args) {
		
		
		 int count = 0;
	        Scanner sc=new Scanner(System.in);
	        String string = sc.nextLine();
	        String sub = sc.nextLine();
	        char a = sub.charAt(sub.length()-1);
	        for(int i=0;i<string.length();i++)
	        {
	            if(string.charAt(i)==a)
	                count++;
	        }
	        System.out.println(count);
	}

}
