package com.songxu.algorithm.tree;
/**
 * ÅÅÐò¶þ²æÊ÷½Úµã
 * @author songxu
 *
 */
public class BinarySortTree  {

	private Integer  value;
	private BinarySortTree leftChild;
	private BinarySortTree rightChild;
	public BinarySortTree(int value)
	{
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinarySortTree getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinarySortTree leftChild) {
		this.leftChild = leftChild;
	}
	public BinarySortTree getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinarySortTree rightChild) {
		this.rightChild = rightChild;
	}


}
