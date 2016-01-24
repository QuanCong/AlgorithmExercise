package com.songxu.algorithm.tree;

import java.util.ArrayList;

/**
 * ��������������
 * @author songxu
 *
 */
public class BinaryTreeOperate {
	
	/**
	 * ��ʼ��һ�Ŷ�����
	 * @param value
	 * @return
	 */
	public static BinaryTreeNode init(Object value)
	{
		BinaryTreeNode rooTreeNode=new BinaryTreeNode(value);
		return rooTreeNode;
		
	}
	/**
	 * ǰ�����
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
	 * �������
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
	 * ��������
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
	 * ��ӡĳһ��Ľڵ�
	 * 
	 * ����˼· :
	 * �Ӹ��ڵ㿪ʼ���εݹ��ӡ���ҽڵ�ֱ����Ҫ����һ��
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
	 * �ֲ����������
	 * ����˼·
	 * ��������Ĵ�ӡĳһ��ķ���  ���� ֱ��ĳһ�㷵�ص�Ϊ�� ֤���Ѿ�ȫ����ӡ���
	 * 
	 * ȱ�㣺ÿ�δ�ӡ��Ҫ�Ӹ��ڵ㿪ʼ����
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
				sBuilder.append("��"+i+"��ڵ㣺");
				for (Object object : subResult) {
					sBuilder.append(object+" ");
				}
				System.out.println(sBuilder.toString());
			}
			
			
		}
	}
	/**
	 * ��α���������
	 * ����˼·��
	 * ����һ������������α� now last
	 * nowָ��ǰ�����Ľ��   lastָ��ǰ������һ���ڵ����һ��λ��
	 * 
	 * ��������Ϊ�����ν�now�����Һ��ӷ���������
	 * 
	 * ��now==last��ʱ�� ��ǰ���������
	 * @param node
	 */
	public static void LevelTraverseSuper(BinaryTreeNode node)
	{
		ArrayList<BinaryTreeNode> arrayList=new ArrayList<>();
		
		int now=0;
		int last=1;
		int level=0;
		arrayList.add(node);
		System.out.println("��"+level+"��ڵ㣺"+node);
		while(now<arrayList.size())//�������� �����ǰָ��û��ָ��last
		{
			last=arrayList.size();
			level ++;
			StringBuilder sBuilder=new StringBuilder();
			sBuilder.append("��"+level+"��ڵ㣺");
			//while�����������Ǳ�����ǰ�� ����ǰ�����һ�㶼����������
			//������λ��Ϊnow-last֮��Ľڵ�
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
