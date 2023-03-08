package com.thinkingme.train.mian.奇安信;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
/**
 * 单车类型只有 ABC三种
 * 输入一个数，代表有多少个单车
 * 求出他们的所有排列方式
 * 要求B车不能在A车之前
 * @author Administrator
 *
 */
public class 单车摆放 {
	public static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		StringBuffer sb = new StringBuffer();
		Set<String> res = new HashSet<>();
		for(int i = 0; i < n ;i++) {
			sb.append(scanner.next());
		}
		backtrack(n, sb.toString().toCharArray(), 0,res );
		System.out.println(res);
		String a= "我是中国人";
		System.out.println(a.charAt(0));
	}
	public static void choose(ArrayList<String> arrayList,int targ,int cur) {
		if(cur == targ) {
			System.out.println(String.join("-", stack));
			return ;
        }
         
        for(int i=cur;i<arrayList.size();i++) {
        	String s = arrayList.get(i);

                stack.add(s);
                choose(arrayList, targ, cur+1);
                stack.pop();
            
        }
	}
	public static void backtrack(int n, char c[], int first,Set<String> res) {

        if (first == n && judge(String.valueOf(c))) {
            res.add(String.valueOf(c));
            return ;
        }
        for (int i = first; i < n; i++) {
        	swap(c, first, i);
            backtrack(n, c, first + 1,res);
        	swap(c, first, i);

        }
    }
	private static void swap(char[] C,int i, int j) {
		char temp=C[i];
		C[i]=C[j];
		C[j]=temp;
	}

	private static boolean judge(String string) {
		int i = string.lastIndexOf("A");
		int j = string.indexOf("B");
		if(i == -1 || j == -1)return true;
		return i<j;
	}
}
