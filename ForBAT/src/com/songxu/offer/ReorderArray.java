package com.songxu.offer;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 * @author songxu
 *
 */
public class ReorderArray {
	
	
	/**
	 * 思路一：
	 * 定义两个指针 分别指向头和尾
	 * 向后移动首指针 直到遇到偶数
	 * 向前以后尾指针，直到遇到奇数
	 * 交换首尾指针
	 * 但是这种方法不能保证相对位置不变
	 * @param array
	 */
	public void solution1(int []array)
	{
		if(array==null||array.length<2)
		{
			return;
		}
		//定义首尾两个指针
		int cursor_front=0;
		int cursor_back=array.length-1;
		
		while(cursor_front<cursor_back)
		{
			while(cursor_front<cursor_back&&(array[cursor_front]&0x1)!=0)
			{
				cursor_front++;//让首指针向后寻找偶数
			}
			while(cursor_back>cursor_front&&(array[cursor_back]&0x1)==0)
			{
				cursor_back--;//尾指针向前寻找奇数
			}
			//交换
			if(cursor_back>cursor_front)
			{
				int temp=array[cursor_back];
				array[cursor_back]=array[cursor_front];
				array[cursor_front]=temp;
			}
		}
		
		
		
		
		
		
	}
	/**
	 * 利用插入排序的思想保证相对位置不变
	 * @param array
	 */
	public void reOrderArray(int []array)
	{
		if(array==null||array.length<2)
		{
			return;
		}
		for(int i=1;i<array.length;i++)
		{
			int temp=array[i];
			//如果发现奇数，就在前面寻找合适的位置将其插入
			if((array[i]&0x1)!=0)
			{
				int j=i-1;
				//因为相对顺序要保持不变，所以把所有的偶数都向后移动
				//把找到的奇数插入到所有的偶数前面
				while(j>=0&&(array[j]&0x1)==0)
				{
					array[j+1]=array[j];
					j--;
				}
				array[j+1]=temp;
			}
		}	
		
		
		
	}

}
