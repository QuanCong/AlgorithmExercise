package com.songxu.newcoder;

/**
 * ʵ��һ���㷨��ɾ�����������м��ĳ����㣬�ٶ���ֻ�ܷ��ʸý�㡣 
 * ������ɾ���Ľڵ㣬��ִ��ɾ�����������ýڵ�Ϊβ�ڵ㣬����false�����򷵻�true
 * 
 * @author songxu
 *
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class RemoveNode {

	public boolean removeNode(ListNode pNode) {
		
		if(pNode==null||pNode.next==null)
		{
			return false;
		}
		/**
		 * �õ�ǰ�ڵ��Ϊ��ǰ�ڵ����һ���ڵ�
		 */
		pNode.val=pNode.next.val;
		pNode.next=pNode.next.next;
		
		return true;
	}
}
