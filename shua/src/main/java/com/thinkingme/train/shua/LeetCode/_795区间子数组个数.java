package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;

/**
 * <p>
 * 795. 区间子数组个数
 * </p>
 *
 * @author: huige
 * @date: 2022/11/24 9:05
 */
public class _795区间子数组个数 {
    public static void main(String[] args) {
        System.out.println(numSubarrayBoundedMax(new int[]{2,1,4,3},2,3));
    }
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }
}
