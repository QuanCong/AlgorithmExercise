package com.songxu.algorithm.tree;

import java.util.ArrayList;

public class BinaryTreeTest {
	
	public static BinaryTreeNode initTree()
	{
		BinaryTreeNode root=BinaryTreeOperate.init(10);
		
		BinaryTreeNode binaryTreeNode1=new BinaryTreeNode(25);
		BinaryTreeNode binaryTreeNode2=new BinaryTreeNode(30);
		BinaryTreeNode binaryTreeNode3=new BinaryTreeNode(36);
		BinaryTreeNode binaryTreeNode4=new BinaryTreeNode(16);
		BinaryTreeNode binaryTreeNode5=new BinaryTreeNode(1);
		BinaryTreeNode binaryTreeNode6=new BinaryTreeNode(6);
		BinaryTreeNode binaryTreeNode7=new BinaryTreeNode(5);
		BinaryTreeNode binaryTreeNode8=new BinaryTreeNode(32);
		BinaryTreeNode binaryTreeNode9=new BinaryTreeNode(110);
		BinaryTreeNode binaryTreeNode10=new BinaryTreeNode(8);
		BinaryTreeNode binaryTreeNode11=new BinaryTreeNode(26);
		
		root.setLeftChild(binaryTreeNode1);
		root.setRightChild(binaryTreeNode5);
		
		binaryTreeNode1.setLeftChild(binaryTreeNode2);
		binaryTreeNode1.setRightChild(binaryTreeNode3);
		
		binaryTreeNode5.setLeftChild(binaryTreeNode6);
		binaryTreeNode5.setRightChild(binaryTreeNode9);
		binaryTreeNode2.setLeftChild(binaryTreeNode4);
		
		
		binaryTreeNode6.setRightChild(binaryTreeNode7);
		binaryTreeNode7.setLeftChild(binaryTreeNode8);
		
		binaryTreeNode9.setLeftChild(binaryTreeNode10);
		binaryTreeNode10.setRightChild(binaryTreeNode11);
		return root;
	}
	
	public static void main(String[] args) {
		
		/*ArrayList<Object> result=new ArrayList<Object>();
		
		result=BinaryTreeOperate.PrintAtLevel(initTree(), 4, result);
		
		for (Object object : result) {
			System.out.println(object);
		}*/
		ThreadBinaryTreeNode node=new ThreadBinaryTreeNode(null);
		 node=	ThreadBinaryTreeOperate.initFromBinaryTree(initTree(), node);
		 node=ThreadBinaryTreeOperate.postOrderInit(node);
		 ArrayList<Object> list=ThreadBinaryTreeOperate.preOrderTraverse(node);
		for (Object object : list) {
			System.out.println(object);
		}
		 
		 System.out.println("123");
		
		
	}

}
