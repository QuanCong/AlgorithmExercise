package com.songxu.huawei;

import java.util.Scanner;
/**
 * 数据表记录包含表索引和数值。请对表索引相同的记录进行合并，合并后表记录为相同索引表的数值求和

 

函数说明：

public int mergeRecord(List oriList, List rstList)

数据表记录包含表索引和数值。请对表索引相同的记录进行合并，合并后表记录为相同索引表的数值求和。


 @param oriList 原始表记录。 以List方式存放，TableRecord定义见TableRecord.java，

                调用者无需对leRecord.java做任何修改
 @param rstList 合并后的表记录 , 以List方式存放
 @return  返回合并后表的个数

 输入描述:

先输入键值对的个数
然后输入成对的index和value值，以空格隔开



输出描述:

输出合并后的键值对（多行）


输入例子:

4
0 1
0 2
1 2
3 4


输出例子:

0 3
1 2
3 4

 * @author songxu
 *
 */
public class MergeTable {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			int key = input.nextInt();
			int value = input.nextInt();
			array[key] += value;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				System.out.println(i + " " + array[i]);
			}
		}
	}

}
