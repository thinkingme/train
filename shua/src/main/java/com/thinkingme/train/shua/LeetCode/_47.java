package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _47
 * @Author: huige
 * @Description: 全排列2
 *
 * @Date: 2021/9/30 10:11
 * @Version: 1.0
 */
public class _47 {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }
/**
 * @Method
 * @Author linzhenhui
 * @Version  1.0
 * @Description
 * 排列模板
 * @Param
 * @Return
 * @Exception
 * @Date 2021/9/30
 */
    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
