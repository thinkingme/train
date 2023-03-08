package com.thinkingme.train.mian.贝壳笔试;

import java.util.*;
/*
 * 输入n和k
*n是数组长度，k是目标
*在输入数组内容 
 *输出一串数字的最长子序列
 *满足子序列中大于k的数比小于k的数多
 *输出最长子序列的长度
 */
public class _3 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int a[] = new int[n];
		for(int i = 0;i<n;i++) {
			a[i] = scn.nextInt();
		}
		int max = 0;
		int flag = 0;
		for(int i = 0;i<n;i++) {
			if(a[i] == k) {
				continue;
			}else if(a[i] > k ) {
				flag += 1;
				if(flag > 0) {
					max = Math.max(max, i+1);
				}
			}else {
				flag -= 1;
				if(flag > 0) {
					max = Math.max(max, i+1);
				}
			}
		}
		System.out.println(max);
	}
    
}
