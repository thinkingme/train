package cn.thinkingme.train.shua.刷题;

import java.util.regex.Pattern;

public class 正则表达式匹配 {
	public static void main(String[] args) {
		System.out.println(Pattern.matches("a*", "a"));
		System.out.println(isMatch("a", "a*"));
	}
	public static boolean isMatch(String s, String p){
	    if (p.length() <= 0) return s.length() <= 0;
	    boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
	    if (p.length() > 1 && p.charAt(1) == '*'){
	        return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
	    } else {
	        return match && isMatch(s.substring(1), p.substring(1));
	    }
	}
}
