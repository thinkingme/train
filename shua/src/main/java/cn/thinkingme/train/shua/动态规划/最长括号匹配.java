package cn.thinkingme.train.shua.动态规划;

import java.util.HashMap;
import java.util.Stack;

public class 最长括号匹配 {
	public static void main(String[] args) {
		System.out.println(max_match(")(()())("));
	}
	/**
	 * 暴力
	 * @param s
	 * @return
	 */
	public static int max_match(String s) {
		int max = 0;
		char a[] = s.toCharArray();
        for(int i = 0;i<s.length();i++) {
        	for(int j = 0;j<s.length();j++) {
            	if(is_match(a, i, j)) {
            		max = Math.max(max, j-i+1);
            	}
            }
        }
        return max;
    }
	public static boolean is_match(char a[],int i ,int j) {
		Stack<Character> s = new Stack<>();
		for(int i1= i ;i1<=j;i1++) {
			if(a[i1] == '(') {
				s.push(a[i]);
			}else if(!s.isEmpty()) {
				s.pop();
			}else return false;
		}
		return s.isEmpty();
	}
	/**
	 * O(n)解决方法
	 * @param s
	 * @return
	 */
	public static int max_match1(String s) {
		int max = 0;
		char a[] = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<a.length;i++) {
        	if(a[i] == '('&& i != 0) {
        		stack.push(i);
        	}else if(!s.isEmpty()) {
        		max = Math.max(max, i-stack.pop()+1);
        	}
        }
        return max;
    }
}
