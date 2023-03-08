package com.thinkingme.train.shua.剑指;

/**
 * <p>
 * 剑指 Offer 14- I. 剪绳子
 * </p>
 *  dps+记忆化自下而上
 *
 * @author: huige
 * @date: 2022/11/28 11:13
 */
public class _1_14剪绳子 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
    public static int cuttingRope(int n) {
        int []dp = new int[n+1];
        if(n == 2)return 1;
        if(n == 3)return 2;
        dp[0]=0;dp[1]=1;dp[2]=2;dp[3]=3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}
