package com.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

public class 剑指Offer53 {
    public static void main(String[] args) {
        int[] nums = {1,4};
        System.out.println(search(nums , 0));
    }

    public static int search(int[] nums, int target) {
        int res = 0;
        int left = 0,right = nums.length-1 ,mid = (left+right)>>1;
        if(nums.length == 1){
            if(target == nums[0])return 1;
            else return 0;
        }
        while(left <= right){
            if(target > nums[mid]){
                left = mid+1;
            }else if (target < nums[mid]) {
                right = mid-1;
            }else{
                res++;
                int mid1 = mid,mid2 = mid;
                for(int i = --mid1 ;i >= 0;i--){
                    if(nums[i] == target){
                        res++;
                    }else{
                        break;
                    }
                }
                for(int i = ++mid2 ;i < nums.length ; i++){
                    if(nums[i] == target){
                        res++;
                    }else{
                        break;
                    }
                }
                return res;
            }
            mid = (left+right)>>1;
        }
        return res;
    }
}
