package cn.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _46
 * @Author: huige
 * @Description: 全排列
 * @Date: 2021/9/30 9:47
 * @Version: 1.0
 */
public class _46 {
    static Stack <Integer>stack = new Stack<Integer>();

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(nums,lists);
        return lists;
    }
    public static void permute(int[] nums,List<List<Integer>> lists) {
        if (stack.size() == nums.length){
            lists.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!stack.contains(nums[i])){
                stack.add(nums[i]);
                permute(nums,lists);
                stack.pop();
            }
        }
    }
}
