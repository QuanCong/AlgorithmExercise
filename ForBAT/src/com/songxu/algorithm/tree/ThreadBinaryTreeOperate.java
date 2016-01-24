package com.songxu.algorithm.tree;

import java.util.ArrayList;

public class ThreadBinaryTreeOperate {
	
	/**
	 * 由一棵二叉树构造先序遍历线索二叉树  不带线索
	 * @param binaryTreeNode
	 * @param threadBinaryTreeNode
	 * @return
	 */
	public static ThreadBinaryTreeNode initFromBinaryTree(BinaryTreeNode binaryTreeNode,ThreadBinaryTreeNode threadBinaryTreeNode)
	{
		if(binaryTreeNode!=null)
		{
			threadBinaryTreeNode=new ThreadBinaryTreeNode(binaryTreeNode.getValue());
		}
		if(binaryTreeNode.getLeftChild()!=null)
		{
			threadBinaryTreeNode.setLeftChild(initFromBinaryTree(binaryTreeNode.getLeftChild(), new ThreadBinaryTreeNode(null)));
		}
		if(binaryTreeNode.getRightChild()!=null)
		{
			threadBinaryTreeNode.setRightChild(initFromBinaryTree(binaryTreeNode.getRightChild(), new ThreadBinaryTreeNode(null)));
			
		}
		return threadBinaryTreeNode;
		
	}
	private static ThreadBinaryTreeNode pre_preOrderInit=null;
	/**
	 * 前序线索化
	 * @param threadBinaryTreeNode
	 * @return
	 */
	public static ThreadBinaryTreeNode preOrderInit(ThreadBinaryTreeNode threadBinaryTreeNode)
	{
		if(threadBinaryTreeNode!=null)
		{
			/**
			 * 代码块部分为线索化部分
			 */
			{
				if(threadBinaryTreeNode.getLeftChild()==null)
				{
					//设置左指针指向前驱
					threadBinaryTreeNode.setLeftTag(true);
					threadBinaryTreeNode.setLeftChild(pre_preOrderInit);
				}
				//如果pre节点的右子树为空，则让pre的右指针指向当前节点
				if(pre_preOrderInit!=null&&pre_preOrderInit.getRightChild()==null)
				{
					
					pre_preOrderInit.setRightTag(true);
					pre_preOrderInit.setRightChild(threadBinaryTreeNode);
				}
				pre_preOrderInit=threadBinaryTreeNode;
			}
			/**
			 * 由于前序遍历的特点  此时左右子树可能已经不为空，但实际上并不指向二叉树的节点，而是一个线索
			 * 所有先判断是否为线索再进行后续的递归操作
			 */
			if(!threadBinaryTreeNode.isLeftTag())
			{
				preOrderInit(threadBinaryTreeNode.getLeftChild());
			}
			if(!threadBinaryTreeNode.isRightTag())
			{
				preOrderInit(threadBinaryTreeNode.getRightChild());
			}
			
		
		
		}
		return threadBinaryTreeNode;
	}
	
	/**
	 * 中序线索化
	 * @param treeNode
	 * @return
	 */
	private static ThreadBinaryTreeNode pre_InOrder=null;
	public static ThreadBinaryTreeNode inOrderInit(ThreadBinaryTreeNode treeNode)
	{
		if(treeNode!=null)
		{
			if(treeNode.getLeftChild()!=null)
			{
				inOrderInit(treeNode.getLeftChild());
			}
			{
				if(treeNode.getLeftChild()==null)
				{
					treeNode.setLeftTag(true);
					treeNode.setLeftChild(pre_InOrder);
				}
				if(pre_InOrder!=null&&pre_InOrder.getRightChild()==null)
				{
					pre_InOrder.setRightTag(true);
					pre_InOrder.setRightChild(treeNode);
				}
				pre_InOrder=treeNode;
			}
			if(treeNode.getRightChild()!=null)
			{
				inOrderInit(treeNode.getRightChild());
			}
		}
		return treeNode;
	}
	private static ThreadBinaryTreeNode pre_PostOrder=null;
	/**
	 * 后续线索化
	 * @param treeNode
	 * @return
	 */
	public static ThreadBinaryTreeNode postOrderInit(ThreadBinaryTreeNode treeNode)
	{
		if(treeNode.getLeftChild()!=null)
		{
			postOrderInit(treeNode.getLeftChild());
		}
		if(treeNode.getRightChild()!=null)
		{
			postOrderInit(treeNode.getRightChild());
		}
		{
			if(treeNode.getLeftChild()==null)
			{
				treeNode.setLeftTag(true);
				treeNode.setLeftChild(pre_PostOrder);
			}
			if(pre_PostOrder!=null&&pre_PostOrder.getRightChild()==null)
			{
				pre_PostOrder.setRightTag(true);
				pre_PostOrder.setRightChild(treeNode);
			}
			pre_PostOrder=treeNode;
		}
		return treeNode;
	}


	/**
	 * 遍历未完成
	 * @param node
	 * @return
	 */
	public static ArrayList<Object> preOrderTraverse(ThreadBinaryTreeNode node)
	{
		ArrayList<Object> list=new ArrayList<Object>();
		
		ThreadBinaryTreeNode node_now=node;
		while(node_now!=null)
		{
			
			while(!node_now.isLeftTag())
			{
				node_now=node_now.getLeftChild();
			}
			list.add(node_now);
			
			while(node_now!=null&&node_now.isRightTag())
			{
				node_now=node_now.getRightChild();
				list.add(node_now);
			}
			
			node_now=node_now.getRightChild();
		}
		
		return list;
		
	}
	




}
