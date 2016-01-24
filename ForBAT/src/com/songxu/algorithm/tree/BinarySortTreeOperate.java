package com.songxu.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySortTreeOperate {
	/**
	 * ����
	 * @param root ��Ŀ¼
	 * @param key  
	 * @param result ���ҽ��
	 * @return �������false����result��¼�������һ�����ʵ��Ľڵ㣬�������true���򷵻ز��ҽ��
	 * 
	 * ����list������õ�����
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
	 * ����ڵ�  ����ֵΪ�޸ĺ�ĸ��ڵ�
	 * @param root ���ڵ�
	 * @param insertNode ����Ľڵ�
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
				root=insertNode;//�²���ڵ�Ϊ���ڵ�
				
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
				//������������Ϊ��
				
				BinarySortTree up=deletedNode.getLeftChild();  //ָ���ҵ������ֵ�ĸ��ڵ�
				BinarySortTree cursor=deletedNode.getLeftChild(); //ָ���ҵ������ֵ�ڵ�
				//whileѭ�����������ҵ�ɾ���ڵ������������ֵ 
				while(cursor.getRightChild()!=null)
				{
					up=cursor;
					cursor=cursor.getRightChild();
				
				}
				
				if(cursor==up)// ���cursor=up ˵��Ҫɾ���ڵ��������������������  ��������ֵ��Ϊ���ֵ
				{
					deletedNode.setValue(up.getValue());
					deletedNode.setLeftChild(up.getLeftChild());
				}
				else {
					
					deletedNode.setValue(cursor.getValue());
					if(cursor.getLeftChild()!=null)//����ҵ������ֵ�ڵ㻹�������������������ӵ���һ��ڵ����������
					{
						up.setRightChild(cursor.getLeftChild());
					}
					
					
				}
				cursor=null;
			}
		}
		else {
			System.out.println("Ҫɾ���Ľڵ㲻����");
		}
		return root;
		
	}
	

}
