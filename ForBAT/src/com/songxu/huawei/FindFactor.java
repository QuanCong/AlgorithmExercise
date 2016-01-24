package com.songxu.huawei;

import java.util.Scanner;

/**
 * ����:����һ�������������մ�С�����˳����������������������ӣ���180����������Ϊ2 2 3 3 5 ��
 * @author songxu
 *
 */
public class FindFactor {
	public static String getResult(Long number) {
		StringBuilder sb = new StringBuilder();
		
		if(number<2)
		{
			return"";
		}
		 else {
			// ʵ���Ͼ���������������
			for (int i = 2; i <= number; i++) {
				// ѭ����i�ǲ���������������ֱ��i������������Ϊֹ(i = 4�ܱ������Ĳ����ܳ��֣���Ϊ��i=2ʱ�Ѿ���ȫ�������)
				// Ҳ����˵number % i==0�������ֻ�е�iΪ����ʱ���п��ܳ��֡�
				while (true) {
					// ���������������number/i��������
					if (number % i == 0) {
						sb.append(i+" ");
						number /= i;
					} else {
						break;
					}
				}
			}

		}
		if(sb.toString().equals(""))
		{
			return sb.append(number).toString();
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			
			String strResult = getResult(scanner.nextLong());

			System.out.println(strResult.trim());

		}
		scanner.close();

	}

}
