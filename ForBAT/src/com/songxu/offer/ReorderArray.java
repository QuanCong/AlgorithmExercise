package com.songxu.offer;
/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������
 * ż����ż��֮������λ�ò��䡣
 * @author songxu
 *
 */
public class ReorderArray {
	
	
	/**
	 * ˼·һ��
	 * ��������ָ�� �ֱ�ָ��ͷ��β
	 * ����ƶ���ָ�� ֱ������ż��
	 * ��ǰ�Ժ�βָ�룬ֱ����������
	 * ������βָ��
	 * �������ַ������ܱ�֤���λ�ò���
	 * @param array
	 */
	public void solution1(int []array)
	{
		if(array==null||array.length<2)
		{
			return;
		}
		//������β����ָ��
		int cursor_front=0;
		int cursor_back=array.length-1;
		
		while(cursor_front<cursor_back)
		{
			while(cursor_front<cursor_back&&(array[cursor_front]&0x1)!=0)
			{
				cursor_front++;//����ָ�����Ѱ��ż��
			}
			while(cursor_back>cursor_front&&(array[cursor_back]&0x1)==0)
			{
				cursor_back--;//βָ����ǰѰ������
			}
			//����
			if(cursor_back>cursor_front)
			{
				int temp=array[cursor_back];
				array[cursor_back]=array[cursor_front];
				array[cursor_front]=temp;
			}
		}
		
		
		
		
		
		
	}
	/**
	 * ���ò��������˼�뱣֤���λ�ò���
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
			//�����������������ǰ��Ѱ�Һ��ʵ�λ�ý������
			if((array[i]&0x1)!=0)
			{
				int j=i-1;
				//��Ϊ���˳��Ҫ���ֲ��䣬���԰����е�ż��������ƶ�
				//���ҵ����������뵽���е�ż��ǰ��
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
