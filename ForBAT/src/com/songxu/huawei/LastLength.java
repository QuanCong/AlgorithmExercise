package com.songxu.huawei;

import java.util.Scanner;
/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 
 * 输入描述:
 * 一行字符串。
 * 输出描述:
 * 整数N，最后一个单词的长度。
 * 
 * 
 * @author songxu
 *
 */
public class LastLength {
	
	public static int getLength(String str)
	{
		if(null==str||str.length()==0)
		{
			return 0;
		}
		else {
			String subStrings[]=str.split(" ");
			return subStrings[subStrings.length-1].length();
		}
	}
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int len = getLength(str);
            System.out.println(len);
        }
 
    }

}
