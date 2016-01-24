package com.songxu.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述 •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组 •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 
 * @author songxu
 *
 */
public class StringSpiltForLength8 {

	public static String[] spiltUtil(String input) {
		if (input == null) {
			return null;
		} else if (input.length() == 0) {
			return new String[] { "00000000" };

		}

		char[] inputchars = input.toCharArray();
		List<Character> charactersWithSpace = new ArrayList<Character>();

		for (char c : inputchars) {
			if (c != Character.SPACE_SEPARATOR) {
				charactersWithSpace.add(c);
			}
		}
		int resultSize=0;
		if(charactersWithSpace.size()%8==0)
		{
			resultSize=charactersWithSpace.size()/8;
		}
		else {
			resultSize=charactersWithSpace.size() / 8 + 1;
		}
		String[] result = new String[resultSize];
		for (int i = 0; i < result.length; i++) {
			char[] subString = new char[8];
			for (int j = 0; j < 8; j++) {
				try {
					subString[j] = charactersWithSpace.get(i * 8 + j);
				} catch (Exception e) {
					// 越界以后 直接填充0
					for (int m = j; m < 8; m++) {
						subString[m] = '0';
					}
					break;
				}

			}

			result[i] = new String(subString);
		}

		return result;

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			String[] strResult = spiltUtil(str);
			for (String string : strResult) {
				System.out.println(string);
			}
		}
		scanner.close();

	}

}
