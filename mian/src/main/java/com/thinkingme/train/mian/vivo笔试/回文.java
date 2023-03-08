package com.thinkingme.train.mian.vivo笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 回文字符串就是正读和反读都一样的字符串，如“viv”、“nexen”、“12321”、“qqq”、“翻身把身翻” 等。
给定一个非空字符串 str，在最多可以删除一个字符的情况下请编程判定其能否成为回文字符串；
如果可以则输出首次删除一个字符所能得到的回文字符串，如果不行则输出字符串 "false" 。
 * @author Administrator
 *
 */
public class 回文 {
	public static void main(String[] args) {
		String s = "lskjl";
		char[] a = s.toCharArray();
		ArrayList<Character> arrayList =new ArrayList<>();
		for(Character character :a) {
			arrayList.add(character);
		}
		Collections.reverse(arrayList);
		System.out.println(arrayList);
	}
}
