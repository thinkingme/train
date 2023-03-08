package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _31
 * @Author: huige
 * @Description: 下一个排列
 * @Date: 2021/8/20 9:19
 * @Version: 1.0
 */
public class _31 {
    public static void main(String[] args) {
        int nums[] = {4,2,0,2,3,2,0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length,left = -1,right = -1;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j < n ;j++){
                if(nums[i]<nums[j]){
                    left = i;
                    right = j;
                }
            }
        }
        if(left != -1){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        Arrays.sort(nums,left + 1,n);
    }
}
//[4,2,0,3,0,2,2]
//2430
//3420