package com.songxu.newcoder;

import java.util.Stack;

/**
 * 
 * @author songxu ����һ���ַ����������һ���㷨���ж����Ƿ�Ϊһ���Ϸ������Ŵ���
 *         ����һ���ַ���A�����ĳ���n���뷵��һ��boolֵ�������Ƿ�Ϊһ���Ϸ������Ŵ���
 * 
 *         ���������� "(()())",6 ���أ�true
 *
 *
 *         ���������� "()a()()",7 ���أ�false
 *
 *
 *         ���������� "()(()()",7 ���أ�false
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
		 * ���ַ�������false
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
