package com.thinkingme.train.mian.伴鱼笔试;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 压缩字符串 {
	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));
	}
	public static String compressString (String str) {
        // write code here
		if(str.length()<=2)return str;
		char a[]  =str.toCharArray();
		StringBuffer stringBuffer = new StringBuffer();
		int count = 1;
		int i ;
		for (i=1;i<a.length;i++) {
			if(a[i] == a[i-1]) {
				count++;
			}else {
				stringBuffer.append(a[i-1]);
				stringBuffer.append(count);
				count = 1;
			}
        }
		stringBuffer.append(a[i-1]);
		stringBuffer.append(count);
		if(stringBuffer.toString().length()<str.length()) {
			return stringBuffer.toString();
		}
		return str;
    }
}
