package com.songxu.huawei;

import java.util.Scanner;



/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
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
