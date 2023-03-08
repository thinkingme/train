package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _15
 * @Author: huige
 * @Description: 三数之和
 * @Date: 2021/7/26 11:53
 * @Version: 1.0
 */
public class _15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int four = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int third = first + 1; third < n; ++third) {
                // 需要和上一次枚举的数不相同
                if (third > first + 1 && nums[third] == nums[third - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (third < four && nums[third] + nums[four] > target) {
                    --four;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (third == four) {
                    break;
                }
                if (nums[third] + nums[four] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[third]);
                    list.add(nums[four]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
