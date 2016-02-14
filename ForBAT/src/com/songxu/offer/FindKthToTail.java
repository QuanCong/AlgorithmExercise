package com.songxu.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author songxu
 *
 */
public class FindKthToTail {

	/**
	 * 首先判断head非空或者k不等于0
	 * 设定两个指针 p1 p2
	 * 倒数第k节点在第n-k+1位置上
	 * 可以让p1走k-1步 
	 * 让p1 p2同时走，p1走到链表尾部的时候 p2指向的就是倒数第K个节点
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head, int k) {

		if (head == null||k==0) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		for (int i = 0; i < k - 1; i++) {
			if (p1.next != null) {
				p1 = p1.next;
			} else {
				return null;
			}

		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;

	}

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

}
