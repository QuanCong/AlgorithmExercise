package com.songxu.algorithm.sort;
/**
 * 快排
 * @author songxu
 *
 */
public class QuickSort {
	
	
	
	public void quickSort(int [] source,int low,int high)
	{
		int pos;
		if(low<high)
		{
			pos=partation2(source, low, high);
			
			quickSort(source, low, pos-1);
			quickSort(source, pos+1, high);
		}
	}
	/**
	 * 减少一次递归的改进方法
	 * @param source
	 * @param low
	 * @param high
	 */
	public void quickSort2(int [] source,int low,int high)
	{
		int pos;
		while(low<high)
		{
			pos=partation2(source, low, high);
			
			quickSort(source, low, pos-1);
			low=pos+1;
		}
	}
	@SuppressWarnings("unused")
	private int partation(int [] source,int low,int high)
	{
		int key=source[low];
		while(low<high)
		{
			while(low<high&&source[high]>=key)
			{
				high--;//从高位向低位走，直到遇到比key小的值
			}
			swap(source, low, high);//第一次交换  相当于把比key小的值放在key的左边
			while(low<high&&source[low]<=key)
			{
				low++;//从低位向高位走，直到遇到比key大的值
			}
			swap(source, low, high);//第二次交换  相当于把比key大的值放在key的右边
			
		}
		return low;
		
	}
	/**
	 * 改进的partation算法  选取首、尾、中间的三个数的中间数作为key
	 * @param source
	 * @param low
	 * @param high
	 * @return
	 */
	@SuppressWarnings("unused")
	private int partation2(int [] source,int low,int high)
	{
		
		int midpos =(low+high)/2;
		
		if(source[low]>source[midpos])
		{
			swap(source, low, midpos);  
		}
		
		if(source[midpos]>source[high])
		{
			swap(source, midpos, high);
		}
		if(source[midpos]>source[low])
		{
			swap(source, midpos, low);
		}
		
		int key=source[low];
		while(low<high)
		{
			while(low<high&&source[high]>=key)
			{
				high--;//从高位向低位走，直到遇到比key小的值
			}
			swap(source, low, high);//第一次交换  相当于把比key小的值放在key的左边
			while(low<high&&source[low]<=key)
			{
				low++;//从低位向高位走，直到遇到比key大的值
			}
			swap(source, low, high);//第二次交换  相当于把比key大的值放在key的右边
			
		}
		return low;
		
	}
	private void swap(int []source,int pos1,int pos2)
	{
		int temp=source[pos1];
		source[pos1]=source[pos2];
		source[pos2]=temp;
	}
	
	public static void main(String[] args) {
		
		int []soure=new int[]{5,1,25,10,23,48,12,20,30,22,33,53,5,6};
		
		QuickSort quickSort=new QuickSort();
		quickSort.quickSort(soure,0,soure.length-1);
		for (int i : soure) {
			System.out.print(i+" ");
		}
		
	}
}
