package com.songxu.huawei;

import java.util.Scanner;

/**
 * д��һ�����򣬽���һ������ĸ�������Լ��ո���ɵ��ַ�������һ���ַ��� Ȼ����������ַ����к��и��ַ��ĸ����������ִ�Сд��
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
