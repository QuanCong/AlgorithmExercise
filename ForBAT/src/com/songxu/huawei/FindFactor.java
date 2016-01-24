package com.songxu.huawei;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
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
			// 实际上就是求他的质因数
			for (int i = 2; i <= number; i++) {
				// 循环求i是不是它的质因数，直到i不是它的因数为止(i = 4能被整除的不可能出现，因为当i=2时已经被全求出来了)
				// 也就是说number % i==0的情况，只有当i为质数时才有可能出现。
				while (true) {
					// 如果能整除，就求number/i的质因数
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
