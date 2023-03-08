package com.thinkingme.train.shua.排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 排列组合一个字符串
 * 给一个字符串，比如ABC， 把所有的排列，即：ABC, ACB, BAC, BCA, CAB, CBC 都找出来。
 * 解题思路：
 * 对于一个n 位的字符串来讲，它是n-1位字符串的排列 加上 没有在 n -1 位字符串里 那个字符 的排列。 
 * 比如：
 * 对于字符串ABC来讲，它所有的排列就是 A + BC 的排列 加上 B + AC 的排列，再加上 C + AB的排列。
 * 而BC的排列是 B + C 的排列 加上 C + B 的排列。
 * 所以，对一个字符串，我们从中去一个值，然后求剩余部分的排列，然后把它们再组合在一起。
 * @author Administrator
 *
 */
public class 字符串不重复排列
{

	static List<String> res = new LinkedList<>();
	public static void main(String[] args)
	{

		String aString ="abc";
		List<String> list=Solution.permutation(aString);
		System.out.println(list);

	}
	
	private static LinkedList<String> permutation(String str)
	{
		LinkedList<String> permuList=new LinkedList<String>();
		
		//递归出口，当只有字符串只包含一个字符的时候
		if(str.length()<=1)
		{
			permuList.add(str);
			return permuList;
		}
		
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);//当前在第一位的字符
			
			//相邻字符相同的情况下，会出现一样的排列组合
			//例如 "AABC"，当i=0时，当前字符'A'，子字符串为"ABC"
			//当i=1时，当前字符为'A'，子字符串为"ABC"，会得到一样的结果
			if(i>0&&ch==str.charAt(i-1))
				continue;
			
			//接下来获取不包含该字符的n-1位字符构成的字符串
			String newStr=getSubString(str,i);
			//递归调用，直到newStr中只包含一个字符时
			LinkedList<String> newPermuList=permutation(newStr);
			for(int j=0;j<newPermuList.size();j++)
			{
				permuList.add(ch+newPermuList.get(j));
			}
		}
		return permuList;
	}
	
	/**
	 * 获取不包含当前字符的子字符串
	 * 如"ABC"，当前字符为'A'，则获取字符串"BC"
	 * @param str 当前字符串
	 * @param i 当前字符的索引位置
	 * @return
	 */
	private static String getSubString(String str,int i)
	{
		//当前字符（ch）位置在str的第一位时
		if(i==0)
			return str.substring(1,str.length());
		//当前字符（ch）位置在str的最后一位时
		if(i==str.length()-1)
			return str.substring(0,str.length()-1);
		return str.substring(0,i)+str.substring(i+1,str.length());
	}
	//第二种办法
	static class Solution {
	    
	    static char[] c;
	    public static  List<String> permutation(String s) {
	        c = s.toCharArray();
	        dfs(0);
	        return res;
	    }
	    static void dfs(int x) {
	        if(x == c.length - 1) {
	            res.add(String.valueOf(c));      // 添加排列方案
	            return;
	        }
	        HashSet<Character> set = new HashSet<>();
	        for(int i = x; i < c.length; i++) {
	            if(set.contains(c[i])) continue; // 重复，因此剪枝
	            set.add(c[i]);
	            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
	            dfs(x + 1);                      // 开启固定第 x + 1 位字符
	            swap(i, x);                      // 恢复交换
	        }
	    }
	    static void swap(int a, int b) {
	        char tmp = c[a];
	        c[a] = c[b];
	        c[b] = tmp;
	    }
	}
	//第三种办法
	class Solution3 {
	    //存放结果
	    List<List<Integer>> result = new ArrayList<>();
	    //暂存结果
	    List<Integer> path = new ArrayList<>();

	    public List<List<Integer>> permuteUnique(int[] nums) {
	        boolean[] used = new boolean[nums.length];
	        Arrays.fill(used, false);
	        Arrays.sort(nums);
	        backTrack(nums, used);
	        return result;
	    }

	    private void backTrack(int[] nums, boolean[] used) {
	        if (path.size() == nums.length) {
	            result.add(new ArrayList<>(path));
	            return;
	        }
	        for (int i = 0; i < nums.length; i++) {
	            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
	            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
	            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
	            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
	                continue;
	            }
	            //如果同⼀树⽀nums[i]没使⽤过开始处理
	            if (used[i] == false) {
	                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树支重复使用
	                path.add(nums[i]);
	                backTrack(nums, used);
	                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
	                used[i] = false;//回溯
	            }
	        }
	    }
	}
}
//栈实现
class Main {
    
    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        int shu[] = {1,2,3};
        f(shu,3,0);
    }
    /**
     *
     * @param shu   待选择的数组
     * @param targ  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    private static void f(int[] shu, int targ, int cur) {
        // TODO Auto-generated method stub
        if(cur == targ) {
            System.out.println(stack);
            return;
        }
         
        for(int i=0;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, cur+1);
                stack.pop();
            }
             
        }
    }
 
}
