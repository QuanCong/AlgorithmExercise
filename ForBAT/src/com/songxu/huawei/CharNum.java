package com.songxu.huawei;

import java.util.Scanner;
/**
 * 
��Ŀ����

��дһ�������������ַ����к��еĲ�ͬ�ַ��ĸ������ַ���ACSII�뷶Χ��(0~127)�����ڷ�Χ�ڵĲ���ͳ�ơ�

��������:

����N���ַ����ַ���ACSII�뷶Χ��(0~127)��



�������:

����ַ��ĸ�����


��������:

abc


�������:

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
