package com.songxu.offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
 * @author songxu
 *
 */
public class FindValueInArray {
	
	public boolean Find(int [][] array,int target) {
		boolean found=false;
		if(array==null||array.length==0||array[0].length==0)
		{
			return found;
		}
		int columns=array[0].length;
		int rows=array.length;
		int row=0;
		int column=columns-1;
		while(row<rows&&column>=0)
		{
			if(array[row][column]==target)
			{
				found=true;
				break;
			}
			else if(array[row][column]>target)//如果右上角的值比target大，则直接剔除当前列
			{
			    column--;	
			}
			else { //在当前列进行查找 向下走
				row++;
			}
		}
		
		
		
		
		return found;
		
    }
	
	public static void main(String[] args) {
		int [][]arrays=new int[2][0];
		System.out.println(arrays[0].length);
		
		
	}

}
