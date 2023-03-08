package com.thinkingme.train.mian.伴鱼笔试;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class 特定元素数组排序 {
	public static void main(String[] args) {
		int a[] = {0,2,1,1};
		System.out.println(Arrays.toString(sort(a)));
	}
	
	public static int[] sort (int[] array) {
        // write code here
		int a[] = new int[array.length];
		int x=0,y=0,z=0;
		for(int i:array) {
			if(i==0)x++;
			else if(i==1){
				y++;
			}else z++;
		}
		int i;
		for(i = 0;i<x;i++) {
			a[i] = 0; 
		}

		int n = i+y;
		for(;i<n;i++) {
			a[i] = 1; 
		}
		n = i+z;
		for(;i<n;i++) {
			a[i] = 2; 
		}
		return a;
    }
}
