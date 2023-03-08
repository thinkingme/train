package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 2006. 差的绝对值为 K 的数对数目
 * </p>
 *
 * @author: huige
 * @date: 2022/2/9 15:39
 */
public class _2006差的绝对值为k的数对数目 {
    public static void main(String[] args) {

    }

    public int countKDifference(int[] nums, int k) {
        int[] cnts = new int[110];
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t - k >= 1) ans += cnts[t - k];
            if (t + k <= 100) ans += cnts[t + k];
            cnts[t]++;
        }
        return ans;
    }
    
}
