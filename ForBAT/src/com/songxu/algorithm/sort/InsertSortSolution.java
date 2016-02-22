package com.songxu.algorithm.sort;
/**
 * ≤Â»Î≈≈–Ú
 * @author songxu
 *
 */
public class InsertSortSolution {
	
	public void insertSort(int []array)
	{
		if(array==null||array.length<2)
		{
			return;
		}
		for(int i=1;i<array.length;i++)
		{
			int temp=array[i];
			while(i>=1&&temp<array[i-1])
			{
				array[i]=array[i-1];
				i--;
			}
			array[i]=temp;
		}
		
	}
	
	public static void main(String[] args) {
		int []array=new int []{1,2,4,5,22,-1,30};
		InsertSortSolution insertSortSolution=new InsertSortSolution();
		insertSortSolution.insertSort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
		
	}
	

}
