package com.songxu.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * �����һ��Ϊһ��������n(1��n��1000),����n��Ϊn���ַ���(�ַ������ȡ�100),�ַ�����ֻ���д�Сд��ĸ��
 * @author songxu
 * �������n�У�������Ϊ�����ֵ������е��ַ�����
 * ��������:

9
cap
to
cat
card
two
too
up
boat
boot

�������:

boat
boot
cap
card
cat
to
too
two
up
 * 
 * 
 *
 */
public class SortWords {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		List<String> list=new ArrayList<String>();
		int length=scanner.nextInt();
		for(int i=0;i<length;i++)
		{
			
			
			list.add(scanner.next());
			
		}
		scanner.close();
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				char fistLeter_1=o1.substring(0,1).toCharArray()[0];
				char fistLeter_2=o2.substring(0,1).toCharArray()[0];
				return fistLeter_1-fistLeter_2;
			}
		});
		
		for (String string : list) {
			System.out.println(string);
		}
		
		
		
	}
	

}
