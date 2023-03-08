package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * <p>
 * 698. 划分为k个相等的子集
 * </p>
 *
 * @author: huige
 * @date: 2022/9/20 10:48
 */
public class _698 {
    public static void main(String[] args) {
        b2de(555);
        pow(2,10);
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k!=0){
            return false;
        }
        return true;
    }
    public static void pow(int num,int point){
        int sum = 1;
        while(point !=0){
            if((point & 1) == 1){
                sum = sum*num;
            }
            num = num * num;
            point>>=1;
        }
        System.out.println(sum);
    }
    public static void b2de(int num){
        int a = 0b10000000000;
        int sum = 0;
        while (a !=0){
            if((a & num) != 0){
                sum = sum*2+1;
            }
            else {
                sum = sum*2;
            }
            a>>=1;
        }
        System.out.println(sum);
    }
}
