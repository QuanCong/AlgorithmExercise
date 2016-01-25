package com.songxu.offer;

import java.util.Arrays;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * 
 * @author songxu
 * 
 * ����˼·��
 * �������������ȷ�����ڵ�λ��  
 * ���ֳ� �������ҡ����������ĸ�������
 * Ȼ��ݹ�
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
		int root = pre[0];// ���ڵ�λ����������ĵ�һ���ڵ�
		int pos = 0;// ȷ�����ڵ������������������ֵ�λ��
		for (; pos < in.length; pos++) {
			if (root == in[pos])
				break;
		}

		int []in_left=Arrays.copyOfRange(in,0,pos);//����������
		int []in_right=Arrays.copyOfRange(in,pos+1, in.length);//����������
		int []pre_left=Arrays.copyOfRange(pre, 1, pos+1);//ǰ��������
		int []pre_right=Arrays.copyOfRange(pre, pos+1, pre.length);//ǰ��������		
		
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
