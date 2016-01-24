package com.songxu.huawei;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	class Error
	{
		public String name;
		public int row;
		public int count=1;
		
		public Error(String name,int row) {
			this.name=name;
			this.row=row;
			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Error other = (Error) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (row != other.row)
				return false;
			return true;
		}

		private Main getOuterType() {
			return Main.this;
		}
		
		
		
		
		
		
	}
	public  Error wrapRecords(String input)
	{
		if(input==null||input.length()==0)
		{
			return null;
		}
		
		String []subStrings=input.split(" ");
		if(subStrings.length!=2)
		{
			return null;
		}
		String path=subStrings[0];
		int row=0;
		try {
			row=new Integer(subStrings[1]);
		} catch (Exception e) {
			return null;
		}
		
		String filename=path.substring(path.lastIndexOf(File.separatorChar)+1);
		if(filename.length()>16)
		{
			filename=filename.substring(filename.length()-16);
		}
		return new Error(filename, row);
	}
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		scanner.useDelimiter("\n");
		List<Error> errors=new ArrayList<Main.Error>();
		Main main=new Main();
		while(scanner.hasNext())
		{
			
			String input=scanner.nextLine();
			if(input.length()==0)
			{
				break;
			}
			
			Error error=main.wrapRecords(input);
			if(error!=null)
			{
				if(errors.contains(error))
				{
					int index=errors.indexOf(error);
					Error errorNow=errors.get(index);
					errorNow.count++;
					errors.add(index, errorNow);
					
				}
				else {
					errors.add(error);
				}
			}
			
			
			
			
			
		}
		scanner.close();
		StringBuilder sBuilder=new StringBuilder();
		if(errors.size()>8)
		{
			for(int i=errors.size()-8;i<errors.size();i++)
			{
				Error error=errors.get(i);
				sBuilder.append(error.name+" "+error.row+" "+error.count+" ");
				
			}
		}
		else {
			for(int i=0;i<errors.size();i++)
			{
				Error error=errors.get(i);
				sBuilder.append(error.name+" "+error.row+" "+error.count+" ");
				
			}
		}
		System.out.println(sBuilder.toString().trim());
	}
	

}
