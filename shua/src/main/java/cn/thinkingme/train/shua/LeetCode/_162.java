package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _162
 * @Author: huige
 * @Description: 寻找峰值
 * @Date: 2021/9/15 10:17
 * @Version: 1.0
 */
public class _162 {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2 ;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
