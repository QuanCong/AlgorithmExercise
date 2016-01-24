package com.songxu.algorithm.sort;

/**
 * �鲢����
 * @author songxu
 *
 */
public class MergeSort {
	
	private void Merge(int []source,int start,int mid,int end)
	{
		int []result=new int[source.length];//�����ʱ����õ�����
		int i=start;//ָ��ǰ��ε��α�
		int j=mid+1;//ָ����ε��α�
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
		if(i<=mid)//˵��ǰ���û�и������
		{
			for(;i<=mid;i++)
			{
				result[k++]=source[i];
			}
		}
		if(j<=end)//˵������û�и������
		{
			for(;j<=end;j++)
			{
				result[k++]=source[j];
			}
		}
		//���start-endλ���ϵ�����õ����鿽����Դ������
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
	 * �ǵݹ�汾ʵ��
	 * ����˼·
	 * 2��2���������  Ȼ��4��4���������
	 * 
	 * ͨ������ left_min  left_max  ָ�������
	 * ͨ������ righ_min  right_max ָ���Ұ���
	 * @param source
	 */
	public void MergeSort2(int []source)
	{
		
		int step=1;//������1����
		
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
				//��ʼ���ұȽ�����
				sort(source, left_min, left_max, right_min, right_max);
			}
			step*=2;
		}
		
		
		
	}
	/**
	 * ��������ϲ�
	 * @param source Դ����
	 * @param left_min  ���������
	 * @param left_max  ���������
	 * @param right_min �Ұ�������
	 * @param right_max �Ұ�������
	 */
	private void sort(int []source,int left_min,int left_max,int right_min,int right_max)
	{
		int []temp=new int [source.length];//��������
		
		int k=left_min;
		int cursorleft=left_min;//��¼����߽�
		int cursorright=right_max;// ��¼���ұ߽� ���ں������� 
		
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
		//����������鸴�ƻ�Դ����
		for(int i=cursorleft;i<cursorright;i++)
		{
			source[i]=temp[i];
		}
		
	}

}
