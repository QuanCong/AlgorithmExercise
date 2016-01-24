package com.songxu.algorithm.sort;

/**
 * 归并排序
 * @author songxu
 *
 */
public class MergeSort {
	
	private void Merge(int []source,int start,int mid,int end)
	{
		int []result=new int[source.length];//存放临时排序好的数组
		int i=start;//指向前半段的游标
		int j=mid+1;//指向后半段的游标
		int k=start;
		for(;i<=mid&&j<=end;k++)
		{
			if(source[i]<source[j])
			{
				result[k]=source[i++];
			}
			else {
				result[k]=source[j++];
			}
		}
		if(i<=mid)//说明前半段没有复制完成
		{
			for(;i<=mid;i++)
			{
				result[k++]=source[i];
			}
		}
		if(j<=end)//说明后半段没有复制完成
		{
			for(;j<=end;j++)
			{
				result[k++]=source[j];
			}
		}
		//最后将start-end位置上的排序好的数组拷贝回源数组中
		for(int cursor=start;cursor<=end;cursor++)
		{
			source[cursor]=result[cursor];
		}
		
		
		
		
	}
	public void Sort(int[]source,int start,int end)
	{
		if(source==null||source.length==0)
		{
			return;
		}
		if(start<end)
		{
			int mid=(start+end)/2;
			Sort(source, start, mid);
			Sort(source, mid+1, end);
			Merge(source, start, mid, end);
			
		}
			
	}
	
	public static void main(String[] args) {
		
		int []soure=new int[]{10,23,48,12,20,30,22,33,53,5,5,6};
		
		MergeSort mergeSort=new MergeSort();
		mergeSort.MergeSort2(soure);
		for (int i : soure) {
			System.out.print(i+" ");
		}
		
	}
	/**
	 * 非递归版本实现
	 * 基本思路
	 * 2个2个结合排序  然后4个4个结合排序
	 * 
	 * 通过划定 left_min  left_max  指定左半区
	 * 通过划定 righ_min  right_max 指定右半区
	 * @param source
	 */
	public void MergeSort2(int []source)
	{
		
		int step=1;//步长由1增大
		
		int left_min=0,left_max=0,right_min=0,right_max=0;
		while(step<source.length-1)
		{
			
			for(left_min=0;left_min<source.length-step;left_min=right_max)
			{
				left_max=right_min=left_min+step;
				right_max=right_min+step;
				if(right_max>source.length)
				{
					right_max=source.length;
				}
				//开始左右比较排序
				sort(source, left_min, left_max, right_min, right_max);
			}
			step*=2;
		}
		
		
		
	}
	/**
	 * 左右区间合并
	 * @param source 源数组
	 * @param left_min  左半区下限
	 * @param left_max  左半区上限
	 * @param right_min 右半区下限
	 * @param right_max 右半区上限
	 */
	private void sort(int []source,int left_min,int left_max,int right_min,int right_max)
	{
		int []temp=new int [source.length];//辅助数组
		
		int k=left_min;
		int cursorleft=left_min;//记录下左边界
		int cursorright=right_max;// 记录下右边界 用于后续复制 
		
		while(left_min<left_max&&right_min<right_max)
		{
			
			if(source[left_min]<=source[right_min])
			{
				temp[k++]=source[left_min++];
			}
			else 
			{
				temp[k++]=source[right_min++];
			}
					
		}
		if(left_min<left_max)
		{
			while(left_min<left_max)
			{
				temp[k++]=source[left_min++];
			}
		}
		if(right_min<right_max)
		{
			while(right_min<right_max)
			{
				temp[k++]=source[right_min++];
			}
		}
		//将排序的数组复制回源数组
		for(int i=cursorleft;i<cursorright;i++)
		{
			source[i]=temp[i];
		}
		
	}

}
