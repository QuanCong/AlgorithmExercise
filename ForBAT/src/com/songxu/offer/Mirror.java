package com.songxu.offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
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
		//交换左右子树
		
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
