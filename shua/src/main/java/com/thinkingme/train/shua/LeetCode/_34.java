package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _34
 * @Author: huige
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * @Date: 2021/8/23 15:57
 * @Version: 1.0
 */
public class _34 {
    public static void main(String[] args) {
        searchRange(new int[]{2,2},2);
    }
    public static int[] searchRange(int[] nums, int target) {
        int res = binSearch(nums,target,0,nums.length-1);
        if(res != -1){
            int left = 0, right = 0;
            for(int i = res;i<nums.length;i++){
                if(nums[i] == nums[res]){
                    right = i;
                }else{
                    break;
                }
            }
            for(int i = res;i>=0;i--){
                if(nums[i] == nums[res]){
                    left = i;
                }else{
                    break;
                }
            }
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }
    public static int binSearch(int[] nums, int target,int left,int right) {
        int mid = left + ((right - left)>>1);
        while(left <= right){
            if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else {
                return mid;
            }
            mid = left + ((right - left)>>1);
        }
        return  -1;
    }
}
