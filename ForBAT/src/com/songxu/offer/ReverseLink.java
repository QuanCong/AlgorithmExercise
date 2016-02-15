package com.songxu.offer;
/**
 * ����һ��������ת�����������������Ԫ�ء�
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
public class ReverseLink {
	
	 public ListNode ReverseList(ListNode head) {
		 
		 if(head==null||head.next==null)
		 {
			 return head;
		 }
		
		 ListNode pfront=null;
		 ListNode pnow=head;
		
		 while(pnow.next!=null)
		 {
			 ListNode pnext=pnow.next;
			 pnow.next=pfront;
			 pfront=pnow;
			 pnow=pnext;
			 
		 }
		 pnow.next=pfront;//�����Ҫ��ǰ��ڵ����
		 return pnow;
		
		
	 }
	 

	 public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode p1=new ListNode(2);
		ListNode p2=new ListNode(3);
		ListNode p3=new ListNode(4);
		ListNode p4=new ListNode(5);
		
		head.next=p1;
		p1.next=p2;
		p2.next=p3;
		p3.next=p4;
		p4.next=null;
		
		
		ReverseLink reverseLink=new ReverseLink();
		head=reverseLink.ReverseList(head);
		
		
		
		
		
		
		
		
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head=head.next;
		}
		
		
		
	}
}
