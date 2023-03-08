package com.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

public class _3 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abba"));
	}
	public static int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()<=0){
        	return 0;
        }
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        int left = -1; //һ��ʼλ��Ҫ���ó�-1
        int res = 0;
        for(int i = 0;i<s.length();i++) {
        	if(hs.containsKey(s.charAt(i))) {
        		left = Math.max(left, hs.get(s.charAt(i)));
        	}
        	hs.put(s.charAt(i), i);
        	res = Math.max(res, i-left);
        }
        return res;
    }
}
