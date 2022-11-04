package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _704
 * @Author: huige
 * @Description: 二分查找
 * @Date: 2021/9/6 8:56
 * @Version: 1.0
 */
public class _704 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,0,3,5,9,12},2));
    }

    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int mid = left+(right-left)/2;
        while(left<=right){
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                return mid;
            }
            mid = left+(right-left)/2;
        }
        return -1;
    }
}
