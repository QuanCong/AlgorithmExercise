package com.songxu.algorithm.avltree;

public class Test {
	
	public static void main(String[] args) {
		
		AVLTreeNode node1=new AVLTreeNode(1);
		
		AVLOperate operate=new AVLOperate();
		
		node1=operate.insert(node1, 2);
		node1=operate.insert(node1, 3);
		node1=operate.insert(node1, 4);
		node1=operate.insert(node1, 5);
		node1=operate.insert(node1, 6);
		node1=operate.insert(node1, 7);
		node1=operate.insert(node1, 16);
		node1=operate.insert(node1, 15);
		node1=operate.insert(node1, 14);
		node1=operate.insert(node1, 13);
		node1=operate.insert(node1, 12);
		node1=operate.insert(node1, 11);
		node1=operate.insert(node1, 10);
		node1=operate.insert(node1, 8);
		node1=operate.insert(node1, 9);
		operate.preOrder(node1);
		
		
		
	}

}
