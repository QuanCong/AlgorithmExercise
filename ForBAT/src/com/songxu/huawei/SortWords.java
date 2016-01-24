package com.songxu.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * @author songxu
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 输入例子:

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

输出例子:

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
