package com.songxu.huawei;

import java.util.Scanner;
/**
 * ���ݱ��¼��������������ֵ����Ա�������ͬ�ļ�¼���кϲ����ϲ�����¼Ϊ��ͬ���������ֵ���

 

����˵����

public int mergeRecord(List oriList, List rstList)

���ݱ��¼��������������ֵ����Ա�������ͬ�ļ�¼���кϲ����ϲ�����¼Ϊ��ͬ���������ֵ��͡�


 @param oriList ԭʼ���¼�� ��List��ʽ��ţ�TableRecord�����TableRecord.java��

                �����������leRecord.java���κ��޸�
 @param rstList �ϲ���ı��¼ , ��List��ʽ���
 @return  ���غϲ����ĸ���

 ��������:

�������ֵ�Եĸ���
Ȼ������ɶԵ�index��valueֵ���Կո����



�������:

����ϲ���ļ�ֵ�ԣ����У�


��������:

4
0 1
0 2
1 2
3 4


�������:

0 3
1 2
3 4

 * @author songxu
 *
 */
public class MergeTable {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			int key = input.nextInt();
			int value = input.nextInt();
			array[key] += value;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				System.out.println(i + " " + array[i]);
			}
		}
	}

}
