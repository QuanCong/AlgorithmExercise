package com.songxu.offer;

/**
 * ����һ����������������е�����k����㡣
 * 
 * @author songxu
 *
 */
public class FindKthToTail {

	/**
	 * �����ж�head�ǿջ���k������0
	 * �趨����ָ�� p1 p2
	 * ������k�ڵ��ڵ�n-k+1λ����
	 * ������p1��k-1�� 
	 * ��p1 p2ͬʱ�ߣ�p1�ߵ�����β����ʱ�� p2ָ��ľ��ǵ�����K���ڵ�
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
