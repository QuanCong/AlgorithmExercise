package com.songxu.algorithm.sort;

/**
 * 堆排序
 * @author songxu
 * 
 * 通过构造大顶堆  每次将堆顶元素移至最后一位 达到排序升序的效果
 *
 */
public class HeapSort {
	
	/**
	 * 在给定位置上调整堆为大顶堆
	 * @param srcArr
	 * @param pos
	 */
	private void heapAdjust(int []srcArr,int pos,int length)
	{
		
		int tmpVal=srcArr[pos];
		
		for(int i=pos*2;i<=length;i*=2)
		{
			if(i<length&&srcArr[i]<srcArr[i+1])
			{
				i++;
			}
			if(srcArr[i]<=tmpVal)
			{
				break;//所有的子节点都比堆顶小  那么就不用向下寻找了  因为默认子节点已经是大顶堆
			}
		    srcArr[pos]=srcArr[i];//交换找到的最大值位置与pos游标指向的堆顶 
		    
		    /*
		     * 交换一次堆顶后  可能子堆不再满足大顶堆的条件 因而需要遍历子堆  再次构造大顶堆
		     * 这里虽然没有执行交换操作 但是上面的if判断始终与tepVal进行比较 相当于把堆顶元素已经交换了一次
		     */
		    pos=i; 
		    
		}
		srcArr[pos]=tmpVal;//最后将tmpValu放在一个合适的位置上
		
	}
	private void swap(int []array,int pos1,int pos2)
	{
		int tmp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=tmp;
	}
	public void heapSort(int []array)
	{
		if(array==null||array.length==0)
		{
			return;
		}
		
		//step1:调整堆为大顶堆
		int length=array.length;
		//填充数组 使得原数组下标从1开始
		int []arrayPushZero=new int [length+1];
		arrayPushZero[0]=Integer.MIN_VALUE;
		System.arraycopy(array, 0, arrayPushZero, 1, array.length);
		
		
		for(int i=length/2;i>0;i--)//从右至左  从下至上  把每个非叶节点当做根构造大顶堆
		{
			heapAdjust(arrayPushZero, i,length);
		}
		for(int i=length;i>1;i--)
		{
			swap(arrayPushZero, 1, i);
			heapAdjust(arrayPushZero, 1,i-1);//除去已排序的元素以后 再次构造大顶堆 因此最后一个参数length始终在变化
			
		}
		System.arraycopy(arrayPushZero, 1, array, 0, length);
	}
	
	public static void main(String[] args) {
		
	
		int []arr=new int []{50,10,90,30,70,40,80,60,20};
		HeapSort heapSort=new HeapSort();
		heapSort.heapSort(arr);
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println(9/2);
	}
	
	
	
	
	

}
