package com.songxu.offer;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * 
 * @author songxu
 *
 */
public class Mirror {

	public void Mirror(TreeNode root) {
		
		if(root==null)
		{
			return;
		}
		if(root.left==null&&root.right==null)
		{
			return ;
		}
		//������������
		
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		Mirror(root.left);
		Mirror(root.right);
		
		

	}

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
}
