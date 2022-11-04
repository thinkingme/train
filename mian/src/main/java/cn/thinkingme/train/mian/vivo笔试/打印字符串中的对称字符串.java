package cn.thinkingme.train.mian.vivo笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * 打印字符串中的对称字符串
 * @author Administrator
 *
 */
public class 打印字符串中的对称字符串 {
	public static void main(String[] args) {
		print("woppocom");
	}
	public static void print(String s) {
		if(s.length()<=1)System.out.println("");
		

		for(int i=0;i<s.length();i++) {
			for(int j=i+2;j<s.length();j++) {
				String s1 = s.substring(i, j);
				char[] a = s1.toCharArray();
				reverse(a);
				if(s1.equals(String.valueOf(a))) {
					System.out.println(s1);
				}
			}
		}
	}
	private static void reverse(char a[]) {
		int j = a.length-1;
		for(int i = 0;i<a.length/2;i++) {
			char temp = a[j];
			a[j--] = a[i];
			a[i] = temp;
		}
	}
}
