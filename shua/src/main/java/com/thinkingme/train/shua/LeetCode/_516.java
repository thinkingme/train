package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _516
 * @Author: huige
 * @Description: 最长回文子序列
 * @Date: 2021/8/12 9:28
 * @Version: 1.0
 */
public class _516 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("aabaaba"));
    }
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][]dp = new int[n][n];
        dp[0][0] = 1;
        int max = 0;
        //从里往外，这样求得最大
        for (int j = 1; j < s.length(); j++) {
            dp[j][j] = 1;
            for (int i = j-1; i >= 0; i--) {
                final boolean b = s.charAt(i) == s.charAt(j);
                if(b){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    //不等于的时候
                    dp[i][j] = Math.max(dp[i+1][j-1],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
