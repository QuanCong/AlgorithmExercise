package com.songxu.newcoder;

import java.util.Stack;

/**
 * 
 * @author songxu 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *         给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 
 *         测试样例： "(()())",6 返回：true
 *
 *
 *         测试样例： "()a()()",7 返回：false
 *
 *
 *         测试样例： "()(()()",7 返回：false
 *
 *
 *
 *
 *
 */
public class Parenthesis {

	public static void main(String[] args) {
		System.out.println(chkParenthesis("(()())", 6));
		System.out.println(chkParenthesis("()a()()", 7));
		System.out.println(chkParenthesis("()(()()", 7));
	}

	public static boolean chkParenthesis(String A, int n) {
		Stack<Character> stackleft = new Stack<>();
		Stack<Character> stackright = new Stack<>();
		/**
		 * 空字符串返回false
		 */
		if (A == null || A.length() == 0) {
			return false;
		}
		char[] chars = A.toCharArray();

		for (char c : chars) {
			if (c == '(') {
				stackleft.push(c);
			} else if (c == ')') {
				stackright.push(c);
			} else {
				continue;
			}
		}
		if (stackleft.size() == stackright.size()) {
			return true;
		} else {
			return false;
		}

	}

}
