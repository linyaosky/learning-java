package me.learning.sort;

import org.junit.Test;

/**
 *实现冒泡排序
 *基本思路（依次比较相邻两个数值的大小，交换）：
 *1.外层循环循环数组的长度-1此
 *2.内层循环次数每次减一（每次排序有一个的顺序确定了，不需要再比了）
 *3.内层依次比较相邻的两个的值。如果前一个大于后一个，就交换。
 *
 *稳定性
 *时间复杂度 ：O(N²)  【假设排序的数字有N个，遍历一趟为O(N)】
 *空间复杂度：O(1)
 */
public class BubbleSort {

	//  排序任意类型的数组
	public <T extends Comparable<T>> void bubbleSort(T[] list){
		T temp = null;
		for(int i=list.length-1; i>0 ; i--){
			boolean flag = false;
			for(int j=0; j<i ;j++){
				if(list[j].compareTo(list[j+1]) > 0){
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}
	
	@Test
	public void testBubbleSort(){
		Integer[] list = {8,54,534,756,87,9,2,43,6};
		bubbleSort(list);
		
		//遍历数组
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
