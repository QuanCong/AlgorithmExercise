package com.songxu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySortTreeOperate {
	/**
	 * 查找
	 * @param root 根目录
	 * @param key  
	 * @param result 查找结果
	 * @return 如果返回false，则result记录的是最后一个访问到的节点，如果返回true，则返回查找结果
	 * 
	 * 利用list解决引用的问题
	 */
	public static boolean find(BinarySortTree root,Integer key,List<BinarySortTree> result)
	{
		if(root==null)
		{
			return false;
		}
		else if(root.getValue()==key) {
			result.set(0, root);
			return true;
		}
		else {
			if(key<root.getValue())
			{
				result.set(0, root);
				return find(root.getLeftChild(), key, result);
			}
			else {
				result.set(0, root);
				return find(root.getRightChild(), key, result);
			}
		}
	}
	/**
	 * 插入节点  返回值为修改后的根节点
	 * @param root 根节点
	 * @param insertNode 插入的节点
	 * @return
	 */
	public static BinarySortTree insert(BinarySortTree root,BinarySortTree insertNode)
	{
		if(insertNode==null)
		{
			return root;
		}
		List<BinarySortTree> result=new ArrayList<>();
		result.add(null);
		if(find(root, insertNode.getValue(),result ))
		{
			return root;
		}
		else {
			if(result.get(0)==null)
			{
				root=insertNode;//新插入节点为根节点
				
			}
			else if(insertNode.getValue()<result.get(0).getValue())
			{
				result.get(0).setLeftChild(insertNode);
				
			}
			else {
				result.get(0).setRightChild(insertNode);
			}
			return root;
		}
		
	}
	
	
	public static BinarySortTree delete(BinarySortTree root,int key)
	{
		ArrayList<BinarySortTree> result=new ArrayList<BinarySortTree>();
		result.add(null);
		if(find(root, key, result))
		{
			BinarySortTree deletedNode=result.get(0);
			if(deletedNode.getLeftChild()==null)
			{
				deletedNode=deletedNode.getRightChild();
			}
			else if(deletedNode.getRightChild()==null)
			{
				deletedNode=deletedNode.getLeftChild();
			}
			else {
				//左右子树都不为空
				
				BinarySortTree up=deletedNode.getLeftChild();  //指向找到的最大值的父节点
				BinarySortTree cursor=deletedNode.getLeftChild(); //指向找到的最大值节点
				//while循环的作用是找到删除节点左子树的最大值 
				while(cursor.getRightChild()!=null)
				{
					up=cursor;
					cursor=cursor.getRightChild();
				
				}
				
				if(cursor==up)// 如果cursor=up 说明要删除节点的左子树不存在右子树  左子树的值即为最大值
				{
					deletedNode.setValue(up.getValue());
					deletedNode.setLeftChild(up.getLeftChild());
				}
				else {
					
					deletedNode.setValue(cursor.getValue());
					if(cursor.getLeftChild()!=null)//如果找到的最大值节点还有左子树，则将左子树接到上一层节点的右子树上
					{
						up.setRightChild(cursor.getLeftChild());
					}
					
					
				}
				cursor=null;
			}
		}
		else {
			System.out.println("要删除的节点不存在");
		}
		return root;
		
	}
	

}
