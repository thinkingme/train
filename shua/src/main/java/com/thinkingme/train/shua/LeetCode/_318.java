package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _318
 * @Author: huige
 * @Description: 最大单词长度乘积
 * @Date: 2021/11/17 9:25
 * @Version: 1.0
 */
public class _318 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
    public static int maxProduct(String[] words) {
        int n  = words.length;
        int []res = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 0; j < words[i].length(); j++) {
                t |= 1 << (words[i].charAt(j) - 'a');
            }
            res[i] = t;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((res[i] & res[j]) == 0){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
