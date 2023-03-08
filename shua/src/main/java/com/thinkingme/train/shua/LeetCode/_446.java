package com.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _446
 * @Author: huige
 * @Description: 等差数列划分 II - 子序列
 * @Date: 2021/8/11 13:47
 * @Version: 1.0
 */
public class _446 {
    public int numberOfArithmeticSlices(int[] nums) {
        // 弱等差子序列的长度至少为2
        int ans = 0, n = nums.length;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                // 首先计算nums[i] 和 nums[j] 之间的差值
                long d = 1L * nums[i] - nums[j];
                // 获得以nums[j]为结尾，差值为d的弱等差子序列的个数
                int cnt = dp[j].getOrDefault(d, 0);
                // 所有以nums[j]为结尾，差值为d的弱等差子序列加上nums[i]后长度至少为3，一定是符合题意的一个等差子序列
                ans += cnt;
                // 以nums[i]结尾，差值为d的弱等差子序列的个数应该额外加上两部分
                //      一部分以nums[j]为结尾，差值为d的弱等差子序列的个数
                //      另一部分是nums[j], nums[i]这两个元素构成的弱等差子序列的个数
                dp[i].put(d, dp[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
