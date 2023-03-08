package com.thinkingme.train.mian.美团面试;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcad"));
	}
	/**
	 * 维护一个不含同样字符的窗口
	 * 末尾为当前位置
	 * 开始是窗口前一个字符的位置
	 * 也是双指针的意思
	 * @param s
	 * @return
	 */
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<=0){
        	return 0;
        }
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        int left = -1; //一开始位置要设置成-1
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
