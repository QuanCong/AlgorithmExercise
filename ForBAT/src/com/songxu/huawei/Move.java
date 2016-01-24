package com.songxu.huawei;

import java.util.Scanner;



/**
 * ����һ��������㹤�ߣ� A��ʾ�����ƶ���D��ʾ�����ƶ���W��ʾ�����ƶ���S��ʾ�����ƶ���
 * �ӣ�0,0���㿪ʼ�ƶ����������ַ��������ȡһЩ���꣬�����������������������ļ����档
 * @author songxu
 *
 */
public class Move {
	
	
	public static int[] getMoved(String input)
	{
		int [] basic=new int []{0,0};
		
		if(null==input||input.length()<2)
		{
			return basic;
		}
		String []inputStrs=input.split(";");
		for (String string : inputStrs) {
			if(string.length()<2)
			{
				continue;
			}
			String firstLeter=string.substring(0,1);
			switch (firstLeter) {
			case "A":
				try {
				 int moved=new Integer(string.substring(1));
				 basic[0]-=moved;
				 break;
				}catch (Exception e) {
					break;
				}
				
			case "D":
				try {
					 int moved=new Integer(string.substring(1));
					 basic[0]+=moved;
					 break;
					}catch (Exception e) {
						break;
					}
			case "W":
				try {
					 int moved=new Integer(string.substring(1));
					 basic[1]+=moved;
					 break;
					}catch (Exception e) {
						break;
					}
			case "S":
				try {
					 int moved=new Integer(string.substring(1));
					 basic[1]-=moved;
					 break;
					}catch (Exception e) {
						break;
					}
			default:
				break;
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		return basic;
		
		
	}
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		while(scanner.hasNext())
		{
			String input=scanner.nextLine();
			int [] result=getMoved(input);
			
			System.out.println(result[0]+","+result[1]);
			
		}
		scanner.close();
		
		
	}
	
	
	
	

}
