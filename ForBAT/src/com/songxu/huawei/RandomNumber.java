package com.songxu.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * ��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ������ü����������N��1��1000֮������������N��100�������������ظ������֣�ֻ����һ������������ͬ����ȥ������ͬ������Ӧ�Ų�ͬ��ѧ����ѧ�š�Ȼ���ٰ���Щ����С�������򣬰����źõ�˳��ȥ��ͬѧ�����顣����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ�����
 * Input Param 

     n               ����������ĸ���     

 inputArray      n�����������ɵ����� 

     

Return Value

     OutputArray    ����������������

 


ע������������֤�����������ȷ�ԣ�������������֤��
 * @author songxu
 *
 */
public class RandomNumber {
	public static Integer[] converter = { 1, 2 };

	public static Integer[] getRandomNumber(Integer[] array) {
		if (array == null) {
			return null;
		} else {
			Set<Integer> noReaptableIntegers = new HashSet<>();
			for (int i : array) {

				noReaptableIntegers.add(i);

			}

			Integer[] resultMid = noReaptableIntegers.toArray(converter);

			Arrays.sort(resultMid);

			return resultMid;

		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			ArrayList<Integer> list = new ArrayList<>();
			int num = scanner.nextInt();
			for (int i = 0; i < num; i++) {
				int n = scanner.nextInt();
				list.add(n);
			}

			Integer[] inputIntegers = list.toArray(converter);
			Integer []resultIntegers=getRandomNumber(inputIntegers);
			for (Integer integer : resultIntegers) {
				System.out.println(integer);
			}
			
			
		}
		scanner.close();

	}

}
