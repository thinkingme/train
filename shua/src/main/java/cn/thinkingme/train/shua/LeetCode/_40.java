package cn.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _40
 * @Author: huige
 * @Description: 组合总和 II
 * @Date: 2021/9/18 9:14
 * @Version: 1.0
 */
public class _40 {
    public static void main(String[] args) {
//        System.out.println(combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
//        },30));
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5,1}, 8));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }
    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }

        for (int start = i; start < candidates.length; start++) {
            if(start>i&&candidates[start]==candidates[start-1])
            {
                continue;
            }
//            System.out.println(start);
            tmp_list.add(candidates[start]);
//            System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start+1, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }
}
