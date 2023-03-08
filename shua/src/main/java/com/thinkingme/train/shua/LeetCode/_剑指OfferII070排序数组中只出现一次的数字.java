package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 * </p>
 *
 * @author: huige
 * @date: 2022/8/9 13:40
 */
public class _剑指OfferII070排序数组中只出现一次的数字 {

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        while (left<right){
            if(mid%2 == 0){
                if (mid-1 >= 0  && nums[mid]==nums[mid-1]){
                    right = mid-1;
                }else if(mid+1< nums.length && nums[mid]==nums[mid+1]){
                    left = mid+1;
                }else {
                    return nums[mid];
                }
            }else{
                if (mid-1 >= 0  && nums[mid]!=nums[mid-1]){
                    right = mid-1;
                }else if(mid+1< nums.length && nums[mid]!=nums[mid+1]){
                    left = mid+1;
                }else {
                    return nums[mid];
                }
            }
            mid = (left+right)/2;
        }
        return nums[mid];
    }
}
