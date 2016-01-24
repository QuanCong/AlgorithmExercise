package com.songxu.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ����һ��int�����������մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�������
 * @author songxu
 *��������:
 *����һ��int������
 *�������:
 *���մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�����
 *��������:
 *9876673
 *�������:
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
