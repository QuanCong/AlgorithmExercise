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
		
		for(int i=pos*2;i<length-1;i*=2)
		{
			if(i<length-1&&srcArr[i]<srcArr[i+1])
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
		
		for(int i=length/2;i>=0;i--)//��������  ��������  ��ÿ����Ҷ�ڵ㵱��������󶥶�
		{
			heapAdjust(array, i,array.length);
		}
		for(int i=array.length-1;i>=0;i--)
		{
			swap(array, 0, i);
			heapAdjust(array, 0,i-1);//��ȥ�������Ԫ���Ժ� �ٴι���󶥶� ������һ������lengthʼ���ڱ仯
			
		}
		
	}
	
	public static void main(String[] args) {
		int []arr=new int []{50,10,90,30,70,40,80,60,20};
		HeapSort heapSort=new HeapSort();
		heapSort.heapSort(arr);
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	
	
	
	

}
