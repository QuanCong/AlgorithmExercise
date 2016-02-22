package com.songxu.algorithm.sort;

/**
 * ������
 * @author songxu
 * 
 * ͨ������󶥶�  ÿ�ν��Ѷ�Ԫ���������һλ �ﵽ���������Ч��
 *
 */
public class HeapSort {
	
	/**
	 * �ڸ���λ���ϵ�����Ϊ�󶥶�
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
				break;//���е��ӽڵ㶼�ȶѶ�С  ��ô�Ͳ�������Ѱ����  ��ΪĬ���ӽڵ��Ѿ��Ǵ󶥶�
			}
		    srcArr[pos]=srcArr[i];//�����ҵ������ֵλ����pos�α�ָ��ĶѶ� 
		    
		    /*
		     * ����һ�ζѶ���  �����ӶѲ�������󶥶ѵ����� �����Ҫ�����Ӷ�  �ٴι���󶥶�
		     * ������Ȼû��ִ�н������� ���������if�ж�ʼ����tepVal���бȽ� �൱�ڰѶѶ�Ԫ���Ѿ�������һ��
		     */
		    pos=i; 
		    
		}
		srcArr[pos]=tmpVal;//���tmpValu����һ�����ʵ�λ����
		
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
		
		//step1:������Ϊ�󶥶�
		int length=array.length;
		//������� ʹ��ԭ�����±��1��ʼ
		int []arrayPushZero=new int [length+1];
		arrayPushZero[0]=Integer.MIN_VALUE;
		System.arraycopy(array, 0, arrayPushZero, 1, array.length);
		
		
		for(int i=length/2;i>0;i--)//��������  ��������  ��ÿ����Ҷ�ڵ㵱��������󶥶�
		{
			heapAdjust(arrayPushZero, i,length);
		}
		for(int i=length;i>1;i--)
		{
			swap(arrayPushZero, 1, i);
			heapAdjust(arrayPushZero, 1,i-1);//��ȥ�������Ԫ���Ժ� �ٴι���󶥶� ������һ������lengthʼ���ڱ仯
			
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
