package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _26
 * @Author: huige
 * @Description: 删除有序数组中的重复项
 * @Date: 2021/8/13 17:07
 * @Version: 1.0
 */
public class _26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int cur  = 0,next = 0;
        for(;next<nums.length;next++){
            if(nums[cur]!=nums[next]){
                nums[count] = nums[next];
                cur = next;
                count++;
            }
        }
        return count;
    }
}
