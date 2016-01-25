package com.songxu.offer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author songxu
 * 
 * 基本思路：
 * 根据先序和中序确定根节点位置  
 * 划分出 先左、先右、中左、中右四个子序列
 * 然后递归
 *
 */
public class RebuildTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}
		int root = pre[0];// 根节点位于先序遍历的第一个节点
		int pos = 0;// 确定根节点在左子树和右子树种的位置
		for (; pos < in.length; pos++) {
			if (root == in[pos])
				break;
		}

		int []in_left=Arrays.copyOfRange(in,0,pos);//中序做序列
		int []in_right=Arrays.copyOfRange(in,pos+1, in.length);//中序右序列
		int []pre_left=Arrays.copyOfRange(pre, 1, pos+1);//前序左序列
		int []pre_right=Arrays.copyOfRange(pre, pos+1, pre.length);//前序右序列		
		
		TreeNode rootNode=new TreeNode(root);
		
		rootNode.left=reConstructBinaryTree(pre_left, in_left);
		rootNode.right=reConstructBinaryTree(pre_right, in_right);
		
		
		return rootNode;
	}
	public static void main(String[] args) {
		
		RebuildTree rebuildTree=new RebuildTree();
		
		
		int []pre=new int []{1,2,4,7,3,5,6,8};
		int []in=new int []{4,7,2,1,5,3,8,6};
		
		TreeNode rootNode=rebuildTree.reConstructBinaryTree(pre, in);
		
		System.out.println("debug");
		
		
		
	}

}
