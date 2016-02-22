package com.songxu.algorithm.sort;

public class BubbleSortSolution {
	
	public void bubbleSort(int []array)
	{
		if(array==null||array.length<2)
		{
			return;
		}
		for(int i=0;i<array.length;i++)
		{
			//从最后一位扫描的i的位置上  找到最小的  连续上升
			for(int j=array.length-1;j>i;j--)
			{
				if(array[j]<array[j-1])
				{
					int temp=array[j-1];
					array[j-1]=array[j];
					array[j]=temp;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int []array=new int []{1,2,4,5,22,-1,30};
		BubbleSortSolution insertSortSolution=new BubbleSortSolution();
		insertSortSolution.bubbleSort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
		
	}

}
