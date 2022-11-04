package cn.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _16
 * @Author: huige
 * @Description: 最接近的三数之和
 * @Date: 2021/7/26 14:22
 * @Version: 1.0
 */
public class _16 {
    public static void main(String[] args) {
        int[] nums = {1,2,5,10,11};
        System.out.println(threeSumClosest(nums,12));
    }
    public static int threeSumClosest(int[] nums, int t) {
        int n = nums.length;
        int res = Integer.MAX_VALUE , m = 0 , abs = 0;
        Arrays.sort(nums);
        for (int first = 0; first < n-2; ++first) {
            int four = n - 1, target = t - nums[first];
            // 枚举 b
            for (int third = first + 1; third < n-1; ++third) {
                // 需要保证 b 的指针在 c 的指针的左侧
                while (third < four && nums[third] + nums[four] > target) {
                    --four;
                }
                if (third == four) {
                    abs = Math.abs(t - nums[first] - nums[third] - nums[four+1]);
                    res = Math.min(res , abs);
                    if(res == abs){
                        m = nums[first] + nums[third] + nums[four+1];
                    }
                    break;
                }
                if (nums[third] + nums[four] == target) {
                    return t;
                }
                if(four < n-1){
                    abs = Math.abs(t - nums[first] - nums[third] - nums[four+1]);
                    res = Math.min(res , abs);
                    if(res == abs){
                        m = nums[first] + nums[third] + nums[four+1];
                    }
                }

                res = Math.min(res , Math.abs(t - nums[first] - nums[third] - nums[four]));
                if(res == Math.abs(t - nums[first] - nums[third] - nums[four])){
                    m = nums[first] + nums[third] + nums[four];
                }
            }
        }
        return m;
    }
}
