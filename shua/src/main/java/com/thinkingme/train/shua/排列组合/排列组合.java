package com.thinkingme.train.shua.排列组合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 排列组合 {
     
    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        int shu[] = {1,2,3,4};
         
        f(shu,2,0,0); // 从这个数组4个数中选择三个
        System.out.println(permute(shu));
    }
     
    /**
     *
     * @param shu  元素
     * @param targ  要选多少个元素
     * @param has   当前有多少个元素
     * @param cur   当前选到的下标
     *
     * 1    2   3     //开始下标到2
     * 1    2   4     //然后从3开始
     */
    private static void f(int[] shu, int targ, int has, int cur) {
        if(has == targ) {
            System.out.println(stack);
            return;
        }
         
        for(int i=cur;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, has+1, i);
                stack.pop();
            }
        }
         
    }
    /**
             * 交换法
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    
}