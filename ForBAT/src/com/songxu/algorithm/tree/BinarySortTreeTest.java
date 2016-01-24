package com.songxu.algorithm.tree;

public class BinarySortTreeTest {
	
	
	public static void main(String[] args) {
		
		int array[]=new int []{62,88,58,47,35,73,51,99,37,36,93};
		BinarySortTree root=null;
		
		for (int i : array) {
			
			root=BinarySortTreeOperate.insert(root, new BinarySortTree(i));
			
		}
		root=BinarySortTreeOperate.delete(root, 47);
		System.out.println(root);
		
	}

}
