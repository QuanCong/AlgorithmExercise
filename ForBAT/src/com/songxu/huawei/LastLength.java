package com.songxu.huawei;

import java.util.Scanner;
/**
 * �����ַ������һ�����ʵĳ��ȣ������Կո������
 * 
 * ��������:
 * һ���ַ�����
 * �������:
 * ����N�����һ�����ʵĳ��ȡ�
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
