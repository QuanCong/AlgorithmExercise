package com.songxu.offer;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и������� 
 * @author songxu
 *
 */
public class FindValueInArray {
	
	public boolean Find(int [][] array,int target) {
		boolean found=false;
		if(array==null||array.length==0||array[0].length==0)
		{
			return found;
		}
		int columns=array[0].length;
		int rows=array.length;
		int row=0;
		int column=columns-1;
		while(row<rows&&column>=0)
		{
			if(array[row][column]==target)
			{
				found=true;
				break;
			}
			else if(array[row][column]>target)//������Ͻǵ�ֵ��target����ֱ���޳���ǰ��
			{
			    column--;	
			}
			else { //�ڵ�ǰ�н��в��� ������
				row++;
			}
		}
		
		
		
		
		return found;
		
    }
	
	public static void main(String[] args) {
		int [][]arrays=new int[2][0];
		System.out.println(arrays[0].length);
		
		
	}

}
