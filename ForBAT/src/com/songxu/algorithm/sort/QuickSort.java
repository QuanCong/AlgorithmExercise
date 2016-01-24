package com.songxu.algorithm.sort;
/**
 * ����
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
	 * ����һ�εݹ�ĸĽ�����
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
				high--;//�Ӹ�λ���λ�ߣ�ֱ��������keyС��ֵ
			}
			swap(source, low, high);//��һ�ν���  �൱�ڰѱ�keyС��ֵ����key�����
			while(low<high&&source[low]<=key)
			{
				low++;//�ӵ�λ���λ�ߣ�ֱ��������key���ֵ
			}
			swap(source, low, high);//�ڶ��ν���  �൱�ڰѱ�key���ֵ����key���ұ�
			
		}
		return low;
		
	}
	/**
	 * �Ľ���partation�㷨  ѡȡ�ס�β���м�����������м�����Ϊkey
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
				high--;//�Ӹ�λ���λ�ߣ�ֱ��������keyС��ֵ
			}
			swap(source, low, high);//��һ�ν���  �൱�ڰѱ�keyС��ֵ����key�����
			while(low<high&&source[low]<=key)
			{
				low++;//�ӵ�λ���λ�ߣ�ֱ��������key���ֵ
			}
			swap(source, low, high);//�ڶ��ν���  �൱�ڰѱ�key���ֵ����key���ұ�
			
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
