package com.songxu.huawei;

import java.util.Scanner;

public class FloatNearby {
	
	
	public static int getNearBy(float input)
	{
		String floadstr=Float.toString(input);
		String []subStrings=floadstr.split("\\.");
		
		if(subStrings.length!=2)
		{
			return new Integer(floadstr);
		}
		else {
			Integer frontInteger=new Integer(subStrings[0]);
			Integer backInteger=new Integer(subStrings[1].substring(0,1));
			if(backInteger>=5)
			{
				return ++frontInteger;
			}
			else {
				return frontInteger;
			}
			
			
			
		}
		
		
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			System.out.println(getNearBy(scanner.nextFloat()));
		}
		scanner.close();
	}

}
