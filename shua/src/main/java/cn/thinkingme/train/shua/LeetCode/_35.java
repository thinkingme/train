package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _35
 * @Author: huige
 * @Description: 搜索插入位置
 * @Date: 2021/8/23 16:18
 * @Version: 1.0
 */
public class _35 {
    public static void main(String[] args) {
        searchInsert(new int[]{1,3,5,6},9);
    }
    public static int searchInsert(int[] nums, int target) {
        return binSearch(nums,target,0,nums.length-1);
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
        return  left;
    }
}
