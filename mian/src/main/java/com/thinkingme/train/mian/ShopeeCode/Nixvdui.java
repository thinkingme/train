package com.thinkingme.train.mian.ShopeeCode;
import java.util.*;
/**
 * 
 * 	逆序对
 * 	给定一个长度为n的排列A,逆序的定义：(i,j)为逆序对，当i<j && A[i]>A[j]
 * 	求排列A的逆序对数量。
 * @author Administrator
 *
 */
public class Nixvdui {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[] = new int[n];
		for(int i = 0;i<n;i++) {
			a[i] = scanner.nextInt();
		}
		
		System.out.println(merge_sort(a, 0, n-1));
		for(int i:a) {
			System.out.print(i);
		}
	}
	
	public static int merge_sort(int a[],int left,int right) {
		if(left>=right)return 0;
		int mid = left +((right-left)>>1);
		return merge_sort(a, left, mid)+merge_sort(a, mid+1, right)+merge(a, left, mid, right);
		
	}
	public static int merge(int a[],int left,int mid, int right) {
		int temp[] = new int[right - left + 1];
		int i=0;
		int p1 = left;
		int p2 = mid+1;
		int res = 0;
		while (p1<=mid&&p2<=right) {
			if(a[p1]<=a[p2]) {
				temp[i++] = a[p1++];
			}else {
				res = res + mid-p1+1;
				temp[i++] = a[p2++];
			}
			
		}
		while(p1<=mid) {
			temp[i++] = a[p1++]; 
		}
		while(p2<=right) {
			temp[i++] = a[p2++]; 
		}
		for(int num : temp) {
			a[left++] = num;
		}
		return res;
	}
}
