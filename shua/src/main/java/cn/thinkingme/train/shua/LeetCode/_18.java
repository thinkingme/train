package cn.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _18
 * @Author: huige
 * @Description: 四数之和
 * @Date: 2021/7/26 17:09
 * @Version: 1.0
 */
public class _18 {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(threeSum(nums,0));
    }
    public static List<List<Integer>> threeSum(int[] nums,int t) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int four = n - 1;
                int target = t - nums[first]-nums[second];
                // 枚举 b
                for (int third = second + 1; third < n; ++third) {
                    // 需要和上一次枚举的数不相同
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
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
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[four]);
                        ans.add(list);
                    }
                }
            }

        }
        return ans;
    }
}
