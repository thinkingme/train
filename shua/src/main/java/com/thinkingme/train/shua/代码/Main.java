package com.thinkingme.train.shua.代码;

import java.util.ArrayList;

/**
 * 求1000以内的所有质数，并且各位数字之和是偶数。
 * @author Administrator
 *
 */
public class Main {
	public static void main(String[] args) {
		count();
	}
	public static void count() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i = 2;i<=1000;i++) {
			if(is_digit(i)&&is_oushu(i)) {
				arrayList.add(i);
			}
		}
		System.out.println(arrayList);
	}
	public static boolean is_digit(int a) {
		if(a == 2)return true;
		for(int i =2;i<=(int)Math.sqrt(a);i++) {
			if(a%i == 0)return false;
		}
		return true;
	}
	public static boolean is_oushu(int a) {
		int sum = 0;
		while(a !=0) {
			sum  = sum + (a%10);
			a = a/10;
		}
		if(sum % 2 ==0)return true;
		else return false;
	}
}
