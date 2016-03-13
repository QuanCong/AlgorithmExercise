package com.songxu.algorithm.avltree;
/**
 * 操作辅助类
 * @author shixi_songxu
 *
 */
public class OperateAssit {

	public static final int height(AVLTreeNode avlTreeNode)
	{
		return avlTreeNode==null?-1:avlTreeNode.height;
	}
	public static final int maxHeight(AVLTreeNode node1,AVLTreeNode node2)
	{
		return height(node1)>height(node2)?height(node1):height(node2);
	}
	/**
	 * 左旋
	 * 左旋就是左子树向上走 成为新的根
	 * @param pos1
	 * @return
	 */
	public static AVLTreeNode rotateLeft(AVLTreeNode pos1)
	{
		AVLTreeNode pos2=pos1.leftNode;
		
		pos1.leftNode=pos2.rightNode;
		pos2.rightNode=pos1;
		//更新高度
		pos1.height=maxHeight(pos1.leftNode, pos1.rightNode)+1;
		pos2.height=maxHeight(pos2.leftNode, pos1.rightNode)+1;
		return pos2;
	}
	/**
	 * 右旋
	 * 右旋就是右子树向上走成为新的根
	 * @param pos1
	 * @return
	 */
	public static AVLTreeNode rotateRight(AVLTreeNode pos1)
	{
		AVLTreeNode pos2=pos1.rightNode;
		pos1.rightNode=pos2.leftNode;
		
		pos2.leftNode=pos1;
		//更新高度
		pos1.height=maxHeight(pos1.leftNode, pos1.rightNode)+1;
		pos2.height=maxHeight(pos2.leftNode, pos1.rightNode)+1;
		
		return pos2;
		
	}
	
	
	/**
	 * 左右旋转 
	 * 先进行一个左旋，再进行一个右旋
	 * 
	 * 适用于 右左插入  在右子树的左子树插入一个节点导致不平衡
	 * @param pos1
	 * @return
	 */
	public static AVLTreeNode rotateLeftRight(AVLTreeNode pos1)
	{
		pos1.rightNode=rotateLeft(pos1.rightNode);
		return rotateRight(pos1);
	}
	
	/**
	 * 右左旋转
	 * 先对左子树进行一个右旋  然后进行一个左旋
	 * 
	 * 适用于 右左插入  在右子树的左子树插入一个节点导致不平衡
	 * @param pos1
	 * @return
	 */
	public static AVLTreeNode rotateRightLeft(AVLTreeNode pos1)
	{
		pos1.leftNode=rotateRight(pos1.leftNode);
		return rotateLeft(pos1);
	}
}
