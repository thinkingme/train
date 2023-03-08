package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _45
 * @Author: huige
 * @Description: 跳跃游戏2
 * @Date: 2021/9/30 9:20
 * @Version: 1.0
 */
public class _45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4,1,1,1,1,1,1,1,1}));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            for (; j <= nums[i]+i &&j<n; j++) {
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
            if(j == n)break;
            int t = i+1;
            if(nums[t]+t < j) i++;
        }
        return dp[n-1];
    }
}
