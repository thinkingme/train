package com.thinkingme.train.mian._4399笔试;

import java.util.ArrayList;
import java.util.Scanner;

public class IPV4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		StringBuffer sb = new StringBuffer();
		char str[] = string.toCharArray();
		ArrayList<String> arrayList = new ArrayList<>();
		for(char a:str) {
			if(a!='.') {
				sb.append(a);
			}else {
				arrayList.add(sb.toString());
				sb = new StringBuffer();
			}
		}
		arrayList.add(sb.toString());
		System.out.println(paseInt(arrayList));
	}
	public static boolean paseInt(ArrayList<String> a) {
		for(String string:a) {
			if(string.length()>3)return false;
			int sum = 0;
			char arr[] = string.toCharArray();
			int j = arr.length-1;
			for(int i = 0;i<arr.length;i++) {
				if(arr[i]<='9'&&arr[i]>='0')
				sum = (arr[i] - '0')*(int)Math.pow(10, j--) +sum;
				else return false;
			}
			if(sum>255)return false;
		}
		return true;
	}
}
