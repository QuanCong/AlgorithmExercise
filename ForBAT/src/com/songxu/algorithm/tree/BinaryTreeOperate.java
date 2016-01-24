package com.songxu.algorithm.tree;

import java.util.ArrayList;

/**
 * 二叉树基本操作
 * @author songxu
 *
 */
public class BinaryTreeOperate {
	
	/**
	 * 初始化一颗二叉树
	 * @param value
	 * @return
	 */
	public static BinaryTreeNode init(Object value)
	{
		BinaryTreeNode rooTreeNode=new BinaryTreeNode(value);
		return rooTreeNode;
		
	}
	/**
	 * 前序遍历
	 * @param node
	 * @param result
	 * @return
	 */
	public static ArrayList<Object> PreOrderTraverse(BinaryTreeNode node,ArrayList<Object> result) {
		if(node==null)
		{
			return result;
		}
		else {
			result.add(node);
			
			if(node.getLeftChild()!=null)
			{
				result=PreOrderTraverse(node.getLeftChild(), result);
			}
			if(node.getRightChild()!=null)
			{
				result=PreOrderTraverse(node.getRightChild(), result);
			}
			
			return result;
		}
		
	}
	/**
	 * 中序遍历
	 * @param node
	 * @param result
	 * @return
	 */
	public static ArrayList<Object> InOrderTraverse(BinaryTreeNode node,ArrayList<Object> result) {
		if(node==null)
		{
			return result;
		}
		else {
			if(node.getLeftChild()!=null)
			{
				result=InOrderTraverse(node.getLeftChild(), result);
			}
			result.add(node);
			if(node.getRightChild()!=null)
			{
				result=InOrderTraverse(node.getRightChild(), result);
			}
			
			return result;
		}
		
	}
	/**
	 * 后续遍历
	 * @param node
	 * @param result
	 * @return
	 */
	public static ArrayList<Object> PostOrderTraverse(BinaryTreeNode node,ArrayList<Object> result) {
		if(node==null)
		{
			return result;
		}
		else {
			if(node.getLeftChild()!=null)
			{
				result=PostOrderTraverse(node.getLeftChild(), result);
			}
			
			if(node.getRightChild()!=null)
			{
				result=PostOrderTraverse(node.getRightChild(), result);
			}
			result.add(node);
			
			
			return result;
		}
		
	}
	/**
	 * 打印某一层的节点
	 * 
	 * 基本思路 :
	 * 从根节点开始依次递归打印左右节点直到需要的那一层
	 * @param node
	 * @param level
	 * @param result
	 * @return
	 */
	public static ArrayList<Object> PrintAtLevel(BinaryTreeNode node,int level,ArrayList<Object> result)
	{
		if(node==null)
		{
			return result;
		}
		if(level==0)
		{
			result.add(node);
			return result ;
		}
		else {
			result=PrintAtLevel(node.getLeftChild(), level-1, result);
			result=PrintAtLevel(node.getRightChild(), level-1, result);
			return result;
			
			
		}
			
	}
	/**
	 * 分层遍历二叉树
	 * 基本思路
	 * 利用上面的打印某一层的方法  遍历 直到某一层返回的为空 证明已经全部打印完毕
	 * 
	 * 缺点：每次打印都要从根节点开始查找
	 * @param node
	 * @param result
	 * @return
	 */
	public static void LevelTraverse(BinaryTreeNode node) 
	{
		ArrayList<ArrayList<Object>> result=new ArrayList<ArrayList<Object>>();
		for(int i=0;;i++)
		{
			ArrayList<Object> subResult=new ArrayList<>();
			subResult=PrintAtLevel(node, i, subResult);
			if(subResult.size()==0)
			{
				break;
			}
			else {
				result.add(subResult);
				StringBuilder sBuilder=new StringBuilder();
				sBuilder.append("第"+i+"层节点：");
				for (Object object : subResult) {
					sBuilder.append(object+" ");
				}
				System.out.println(sBuilder.toString());
			}
			
			
		}
	}
	/**
	 * 层次遍历二叉树
	 * 基本思路：
	 * 设置一个数组和两个游标 now last
	 * now指向当前操作的结点   last指向当前层的最后一个节点的下一个位置
	 * 
	 * 操作定义为：依次将now的左右孩子放入数组中
	 * 
	 * 当now==last的时候 当前层操作结束
	 * @param node
	 */
	public static void LevelTraverseSuper(BinaryTreeNode node)
	{
		ArrayList<BinaryTreeNode> arrayList=new ArrayList<>();
		
		int now=0;
		int last=1;
		int level=0;
		arrayList.add(node);
		System.out.println("第"+level+"层节点："+node);
		while(now<arrayList.size())//结束条件 如果当前指针没有指向last
		{
			last=arrayList.size();
			level ++;
			StringBuilder sBuilder=new StringBuilder();
			sBuilder.append("第"+level+"层节点：");
			//while操作的作用是遍历当前层 将当前层的下一层都放入数组中
			//遍历的位置为now-last之间的节点
			while(now<last)
			{
				if(arrayList.get(now).getLeftChild()!=null)
				{
					sBuilder.append(arrayList.get(now).getLeftChild()+" ");
					arrayList.add(arrayList.get(now).getLeftChild());
				}
				if(arrayList.get(now).getRightChild()!=null)
				{
					sBuilder.append(arrayList.get(now).getRightChild()+" ");
					arrayList.add(arrayList.get(now).getRightChild());
				}
				now++;
			}
			
			System.out.println(sBuilder.toString());
			
			
			
			
		}
		
		
		
		
	}

}
