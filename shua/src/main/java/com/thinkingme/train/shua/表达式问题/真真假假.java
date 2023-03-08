package com.thinkingme.train.shua.表达式问题;

/**
 * 目标：java实现直接算出中缀表达式：例：3+2*5-6的值
 * 思路：1.分别把数字，和符号放入两个栈中
 *      2.如果是数字：直接入数字栈
 *      3.如果是符号，当前符号的优先级别小于等于上一个符号，
 *      	数字栈pop两个值，符号栈pop出一个符号运算，值放入数字栈，当前符号入符号栈
 *                  当前符号的优先级大于上一个符号，符号直接入符号栈
 *      4.一次取出数字栈的值，符号栈的符号，依次运算，值入数字栈
 *      5.知道数字栈中只有一个值（或者符号栈为空）结束，取出数字栈的当前值为最终结果
 */
import java.util.Stack;

public class 真真假假 {
	public static void main(String[] args) {
		System.out.println(calc("真与真与假或真"));
		System.out.println(calc1("1+2*3+5"));
	}
	private static char calc(String string) {
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		char a[] = string.toCharArray();
		for(int i = 0;i<a.length;i++) {
			if(a[i] == '真' || a[i] == '假') {
				s1.push(a[i]);
			}else if(a[i] == '或') {
				if(s2.isEmpty()) {
					s2.push(a[i]);
				}else if(s2.peek() == '与') {
					s2.push(a[i]);
				}else {
					s1.push(judge(s1.pop(), s1.pop(), s2.pop()));
				}
			}else {
				if(s2.isEmpty()) {
					s2.push(a[i]);
				}else{
					s1.push(judge(s1.pop(), s1.pop(), s2.pop()));
					s2.push(a[i]);
				}
				
			}
		}

		while(s1.size() > 1) {
			s1.push(judge(s1.pop(), s1.pop(), s2.pop()));
		}

		return s1.pop();
	}
	private static char judge(char a,char b,char c) {
		if(c == '与') {
			if( a == '真' && b == '真') {
				return '真';
			}else {
				return '假';
			}
		}else {
			if( a == '假' && b == '假') {
				return '假';
			}else {
				return '真';
			}
		}
		
	}
	private static int calc1(String string) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		char a[] = string.toCharArray();
		for(int i = 0;i<a.length;i++) {
			if(a[i] <= '9' && a[i] >= '0') {
				s1.push(Integer.parseInt(a[i]+""));
			}else if(a[i] == '*') {
				if(s2.isEmpty()) {
					s2.push(a[i]);
				}else if(s2.peek() != '*') {
					s2.push(a[i]);
				}else {
					s1.push(judge1(s1.pop(), s1.pop(), s2.pop()));
				}
			}else {
				if(s2.isEmpty()) {
					s2.push(a[i]);
				}else{
					s1.push(judge1(s1.pop(), s1.pop(), s2.pop()));
					s2.push(a[i]);
				}
				
			}
		}

		while(s1.size() > 1) {
			s1.push(judge1(s1.pop(), s1.pop(), s2.pop()));
		}

		return s1.pop();
	}
	private static int judge1(int a,int b,char c) {
		if(c == '*') {
			return a*b;
		}else {
			return a+b;
		}
		
	}
}
