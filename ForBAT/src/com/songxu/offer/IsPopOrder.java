package com.songxu.offer;

import java.util.Stack;



/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳��
 * ���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
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
		int cursor=0;//��¼pushA���α�λ��
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
