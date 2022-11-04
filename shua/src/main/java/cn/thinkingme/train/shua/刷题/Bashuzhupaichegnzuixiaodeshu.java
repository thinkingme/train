package cn.thinkingme.train.shua.刷题;

import java.util.Arrays;

public class Bashuzhupaichegnzuixiaodeshu {
	public String PrintMinNumber(int[] numbers) {
		Integer[] a= new Integer[8];
		Integer []ia = a;
		Arrays.sort(a, (s1, s2) -> s1-s2);
	    if (numbers == null || numbers.length == 0)
	        return "";
	    int n = numbers.length;
	    String[] nums = new String[n];
	    for (int i = 0; i < n; i++)
	        nums[i] = numbers[i] + "";
	    Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
	    String ret = "";
	    for (String str : nums)
	        ret += str;
	    return ret;
	}
}
