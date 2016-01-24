package com.songxu.algorithm.tree;
/**
 * 二叉树节点设计
 * @author songxu
 *
 */
public class BinaryTreeNode {
	
	private Object value;
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;
	public BinaryTreeNode(Object value)
	{
		this.value=value;
	}
	public BinaryTreeNode(Object value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
	

}
