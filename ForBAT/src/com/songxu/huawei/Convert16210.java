package com.songxu.huawei;

import java.util.Scanner;

public class Convert16210 {
	
	
	public static Integer ConverUtil(String input)
	{
		if(input==null||input.length()==0)
		{
			return null;
		}
		else {
			if(input.startsWith("0x"))
			{
				input=input.substring(2);
			}
			
			int result=0;
			char []subString=input.toCharArray();
			for(int i=0;i<subString.length;i++)
			{
				//首先检验字母合法性  48-57  65-69
				if(subString[i]<48||subString[i]>70)
				{
					return null;
				}
				else if(subString[i]>57&&subString[i]<65) {
					return null;
				}
				if(subString[i]<=57)
				{
					result+=(subString[i]-48)*Math.pow(16, subString.length-i-1);
				}
				else {
					result+=(subString[i]-55)*Math.pow(16, subString.length-i-1);
				}
				
				
			}
			return result;
		}
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			System.out.println(ConverUtil(str));
		}
		scanner.close();
	}
}

