package com.songxu.algorithm.tree;
/**
 * 线索二叉树的节点
 * @author songxu
 *
 */
public class ThreadBinaryTreeNode {
	
	private Object value;
	private ThreadBinaryTreeNode leftChild;
	private ThreadBinaryTreeNode rightChild;
	private boolean leftTag=false;
	private boolean rightTag=false;
	
	public ThreadBinaryTreeNode(Object value)
	{
		this.value=value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ThreadBinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(ThreadBinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public ThreadBinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(ThreadBinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public boolean isLeftTag() {
		return leftTag;
	}

	public void setLeftTag(boolean leftTag) {
		this.leftTag = leftTag;
	}

	public boolean isRightTag() {
		return rightTag;
	}

	public void setRightTag(boolean rightTag) {
		this.rightTag = rightTag;
	}
	
	

}
