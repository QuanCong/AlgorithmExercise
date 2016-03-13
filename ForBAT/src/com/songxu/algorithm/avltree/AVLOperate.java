package com.songxu.algorithm.avltree;

import com.sun.media.sound.RIFFInvalidDataException;

public class AVLOperate {
	/**
	 * 插入节点
	 * http://blog.chinaunix.net/uid-24948645-id-3913917.html
	 * @param root
	 * @param insertNode
	 * @return
	 */
	public AVLTreeNode insert(AVLTreeNode root,Integer value)
	{
		if(root==null)
		{
			return new AVLTreeNode(value);
		}
		if(value<root.value)
		{
			root.leftNode=insert(root.leftNode,value);
			if(OperateAssit.height(root.leftNode)-OperateAssit.height(root.rightNode)==2)//需要进行旋转
			{
				if(value<root.leftNode.value)
				{
					//左子树的左节点插入 左旋
					root=OperateAssit.rotateLeft(root);
				}
				else {
					//左子树右节点插入 右左旋
					root=OperateAssit.rotateRightLeft(root);
				}
				
				
			}
		
		}
		else {
			root.rightNode=insert(root.rightNode,value);
			if(OperateAssit.height(root.rightNode)-OperateAssit.height(root.leftNode)==2)//需要进行旋转
			{
				
				if(value<root.rightNode.value)
				{
					//右子树左节点插入  左右旋
					root=OperateAssit.rotateLeftRight(root);
				}
				else {
					//右子树右节点插入  右旋
					root=OperateAssit.rotateRight(root);
				}
			}
		}
		//在未旋转的情况下，没有更新root的heigh，要单独再计算一次	
		root.height=OperateAssit.maxHeight(root.leftNode, root.rightNode)+1;
		
		return root;
	}
	
	
	public void preOrder(AVLTreeNode root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.value+" ");
		if(root.leftNode!=null)
		{
			preOrder(root.leftNode);
		}
		if(root.rightNode!=null)
		{
			preOrder(root.rightNode);
		}
	}
	
	
	
	public void delete(AVLTreeNode root,int value)
	{
		if(root==null)return;//没找到
		if(value<root.value)
		{
			
			delete(root.leftNode, value);//在左子树上删除
			if(OperateAssit.height(root.rightNode)-OperateAssit.height(root.leftNode)==2)
			{
				//删除操作发生在左子树  要查看右子树的平衡因子
				
				//如果右子树的左子树不为空 且右子树的左子树高  那么就是右左的情况  需要一次左右旋转
				if(root.rightNode.leftNode!=null||OperateAssit.height(root.rightNode.leftNode)>OperateAssit.height(root.rightNode.rightNode))
				{
					root=OperateAssit.rotateLeftRight(root);
				}
				else {
					root=OperateAssit.rotateRight(root);
				}
				
			}
			
		}
		else if(value>root.value)
		{
			delete(root.rightNode, value);
			
			if(OperateAssit.height(root.leftNode)-OperateAssit.height(root.rightNode)==2)
			{
				//删除操作发生在右子树，所以要查看左子树的情况
				
				//如果左子树的右子树不为空  且左子树的右子树高 就是插入时候的 左右情况  那么进行一次 右左旋转
				if(root.leftNode.rightNode!=null||OperateAssit.height(root.leftNode.rightNode)>OperateAssit.height(root.leftNode.leftNode))
				{
					root=OperateAssit.rotateRightLeft(root);
				}
				else {
					root=OperateAssit.rotateLeft(root);
				}
				
			}
			
		}
		else {
			//找到节点 
			
			//如果root节点有左子树和右子树
			if(root.leftNode!=null&&root.rightNode!=null)
			{
				AVLTreeNode nodeTemp=root.rightNode;
				//找到右子树最最小的节点  用它的值替换掉root
				while(nodeTemp.leftNode!=null)
				{
					nodeTemp=nodeTemp.leftNode;
				}
				root.value=nodeTemp.value;
				
				delete(root, nodeTemp.value);//删除这个节点
				
				//右子树再平衡判断
				if(OperateAssit.height(root.leftNode)-OperateAssit.height(root.rightNode)==2)
				{
					//删除操作发生在右子树，所以要查看左子树的情况
					
					//如果左子树的右子树不为空  且左子树的右子树高 就是插入时候的 左右情况  那么进行一次 右左旋转
					if(root.leftNode.rightNode!=null||OperateAssit.height(root.leftNode.rightNode)>OperateAssit.height(root.leftNode.leftNode))
					{
						root=OperateAssit.rotateRightLeft(root);
					}
					else {
						root=OperateAssit.rotateLeft(root);
					}
					
				}
			}
			//这个节点只有一个或没有子节点
			else {
				
				if(root.leftNode!=null)
				{
					root=root.leftNode;
				}
				else if(root.rightNode!=null) {
					root=root.rightNode;
				}
			
				
			}
			
			
		}
		//重新计算root高度
		root.height=OperateAssit.maxHeight(root.leftNode, root.rightNode)+1;
		
	}

}
