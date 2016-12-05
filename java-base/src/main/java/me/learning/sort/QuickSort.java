package me.learning.sort;

/**
 * 快速排序
 * 基本思路：（使用分治策略。）
 * 1.选择一个基准数
 * 2.一趟排序可以将要排序的数据分为两部分，一部分的数据比另一部分的所有数据都小。
 * 3.对两部分数据做第二步同样的操作（递归实现）。知道每部分数据只有一个数
 * 
 * 不稳定的排序 
 */
public class QuickSort {
	
	 public static void quickSort(int[] a, int l, int r) {
	      if (l < r) {
	    	  int i,j,x;
	 
              i = l;
              j = r;
              x = a[i];
              while (i < j) {
                  while(i < j && a[j] > x)
                      j--; // 从右向左找第一个小于x的数
                  if(i < j)
                      a[i++] = a[j];
                  while(i < j && a[i] < x)
                      i++; // 从左向右找第一个大于x的数
                  if(i < j)
                      a[j--] = a[i];
              }
              a[i] = x;
              quickSort(a, l, i-1); /* 递归调用 */
              quickSort(a, i+1, r); /* 递归调用 */
	      }
	}
}
