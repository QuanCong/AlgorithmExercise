package com.songxu.offer;

import java.util.Stack;



/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * @author songxu
 *
 */
public class IsPopOrder {
	
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		
		boolean result=false;
		if(popA==null||popA.length==0)
		{
			return result;
		}
		if(pushA==null||pushA.length==0)
		{
			return false;
		}
		if(pushA.length!=popA.length)
		{
			return false;
		}
		Stack<Integer> assiStack=new Stack<Integer>();
		int cursor=0;//记录pushA的游标位置
		for(int i=0;i<popA.length;i++)
		{
			if(assiStack.isEmpty())
			{
				assiStack.push(pushA[cursor]);
			}
			while(assiStack.peek()!=popA[i])
			{
				if(cursor<pushA.length)
				{
					assiStack.push(pushA[cursor]);
					cursor++;
				}
				else {
					return false;
				}
				
			}
			assiStack.pop();
			
		}
		
	    return true;  
    }
	public static void main(String[] args) {
		
		int []pushA=new int []{1,2,3,4,5};
		int []popA=new int []{4,5,3,2,1};
		
		IsPopOrder isPopOrder=new IsPopOrder();
		
		System.out.println(isPopOrder.IsPopOrder(pushA, popA));
		
	}
}
