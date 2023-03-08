package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/11/19 9:38
 */
public class _1732找到最高海拔 {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

    public static int largestAltitude(int[] gain) {
        int cur =  0,max = 0;
        for(int i = 0;i<gain.length;i++){
            max = Math.max(max,cur = cur+gain[i]);
        }
        return max;
    }
}
