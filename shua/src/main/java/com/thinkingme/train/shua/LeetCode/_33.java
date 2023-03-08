package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _33
 * @Author: huige
 * @Description: 搜索旋转排序数组
 * @Date: 2021/8/23 9:07
 * @Version: 1.0
 */
public class _33 {
    public static void main(String[] args) {
        int []nums = {0,1};
        System.out.println(search(nums,1));
    }
    public static int search(int[] nums, int target) {
        if(nums.length <= 1) return target == nums[0]?0:-1;
        int t = nums.length-1;
        for(int i = 1 ;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                t = i-1;
                break;
            }
        }
        if( t == nums.length-1){
            return binSearch(nums,target,0,t);
        }else{
            if(target <= nums[t] && target >= nums[0]){
                return binSearch(nums,target,0,t);
            }else if(target >= nums[t+1] && target <= nums[nums.length-1]){
                return binSearch(nums,target,t+1,nums.length-1);
            }
        }
        return -1;
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
