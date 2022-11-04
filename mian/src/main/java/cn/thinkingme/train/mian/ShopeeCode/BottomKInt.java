package cn.thinkingme.train.mian.ShopeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * @author Administrator
 *
 */
public class BottomKInt {
	public static void main(String[] args) {
		int a[] = {1,3,5,7,2,4,6,8};
		System.out.println(Arrays.toString(smallestK(a, 4)));
	}
	 public static int[] smallestK(int[] arr, int k) {
		 PriorityQueue<Integer> pQueue= new PriorityQueue<>(
				 (i1,i2)->i2-i1
				 );
		 for(int i:arr) {
			 pQueue.add(i);
			 if(pQueue.size()>k) {
				 pQueue.poll();
			 }
		 }
		 int z= 0;
		 int a[] = new int[k];
		 for(int i:pQueue) {
			 a[z++] =i;
		 }
		 return a;
	 }
}
