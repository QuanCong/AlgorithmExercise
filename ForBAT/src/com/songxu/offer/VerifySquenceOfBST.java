package com.songxu.offer;

import java.util.Arrays;

/**
 * ����һ���������飬
 * �жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * @author songxu
 *
 */
public class VerifySquenceOfBST {

	public boolean VerifySquenceOfBST(int [] sequence) {
		
		if(sequence==null||sequence.length==0)
		{
			return false;
		}
		
		int root =sequence[sequence.length-1];
		
		int left_index=0;
		for(;left_index<sequence.length-1;left_index++)
		{
			if(sequence[left_index]>root)
			{
				break;
			}
		}
		
		int right_index=left_index;
		for(;right_index<sequence.length-1;right_index++)
		{
			if(sequence[right_index]<root)
			{
				return false;
			}
		}
		boolean left=true;
		if(left_index>0)
		{
			int [] left_child=Arrays.copyOf(sequence, left_index);
			left=VerifySquenceOfBST(left_child);
		}
		boolean right =true;
		if(left_index<sequence.length-1)
		{
			int [] right_child=Arrays.copyOfRange(sequence, left_index, sequence.length-1);
			right=VerifySquenceOfBST(right_child);
		}
		return left&&right;
		
        
    }
	
	public static void main(String[] args) {
		VerifySquenceOfBST verifySquenceOfBST=new VerifySquenceOfBST();
		
		int []s=new int []{5,7,6,9,11,10,8};
		System.out.println(verifySquenceOfBST.VerifySquenceOfBST(s));
		
		
	}
}
