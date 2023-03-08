package com.thinkingme.train.mian.ShopeeCode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 
 * 给定String类型的数组strArr，再给定整数k，请严格按照排名顺序打印 出次数前k名的字符串。
[要求]
如果strArr长度为N，时间复杂度请达到O(N \log K)O(NlogK)
 * @author Administrator
 *
 */
public class TopKString {
	public static void main(String[] args) {
		
	}
	public String[][] topKstrings (String[] strings, int k) {
        // write code here
		HashMap<String,Integer> hashMap = new HashMap<>();
		for(String string:strings) {
			hashMap.put(string, hashMap.getOrDefault(string, 0)+1);
		}
		PriorityQueue<String> pStrings = new PriorityQueue<>(
				(s1,s2)->hashMap.get(s1).equals(hashMap.get(s2)) ? 
						s2.compareTo(s1):hashMap.get(s1)-hashMap.get(s2)
		);
		for(String s:hashMap.keySet()) {
			pStrings.add(s);
			if(pStrings.size()>k) {
				pStrings.poll();
			}
		}
		String [][]reStrings = new String[k][2];

		int j = k-1;
        while (!pStrings.isEmpty()) {
            String tmp = pStrings.poll();
            reStrings[j][0] = tmp;
            reStrings[j][1] = hashMap.get(tmp) + "";
            j--;
        }	         
		return reStrings;

    }
}
