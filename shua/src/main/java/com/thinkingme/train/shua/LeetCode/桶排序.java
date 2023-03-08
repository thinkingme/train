package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;
/**
 * 一个无序数组，排序后返回相邻两数的最大差值
 * @author huige
 *
 */
public class 桶排序 {

    public static int maxDiff(int[] nums) {
    	if ( nums.length < 2) return 0;
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if(max == min) return 0;
        int d =  Math.max(1, (max - min) / n );
        int bucketSize = (max - min) / d ;

        int[] count = new int[bucketSize+1];
        int[] maxs = new int[bucketSize+1];
        int[] mins = new int[bucketSize+1];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        Arrays.fill(mins, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
        	//(nums[i] - min)/ (max - min）取值范围为0-1
        	//所以(nums[i] - min)/ (max - min）*n取值范围为0-n
        	//划分成了n+1个桶
            int index = (nums[i] - min) / d;
            
            count[index]++;
            maxs[index] = Math.max(maxs[index], nums[i]);
            mins[index] = Math.min(mins[index], nums[i]);
        }

        int maxDif = Integer.MIN_VALUE;
        int pre = maxs[0];
        for (int i = 1; i < bucketSize+1; i++) {
            if (count[i] > 0) {
                maxDif = Math.max(maxDif, mins[i] - pre);
                pre = maxs[i];
            }
        }

        return maxDif;
    }

    public static void main(String[] args) {
        int[] nums = {1,100000};
        System.out.println(maxDiff(nums));

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("---------------");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(Math.abs(nums[i] - nums[i + 1]));
        }
        System.out.println("---------------");
    }
}
