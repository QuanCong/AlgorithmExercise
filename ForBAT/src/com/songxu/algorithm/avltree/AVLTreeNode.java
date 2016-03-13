package com.songxu.algorithm.avltree;

public class AVLTreeNode {
	
	public int value;
	public int height;
	public AVLTreeNode leftNode;
	public AVLTreeNode rightNode;
	
	public AVLTreeNode(int value)
	{
		this.value=value;
		height=0;
		leftNode=rightNode=null;
	}

}
