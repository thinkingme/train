package com.thinkingme.train.shua.LeetCode;

import java.util.HashSet;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _575
 * @Author: huige
 * @Description: 分糖果
 * @Date: 2021/11/1 13:54
 * @Version: 1.0
 */
public class _575 {
    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1,1,2,3}));
    }
    public static int distributeCandies(int[] candyType) {
        HashSet<Integer> integers = new HashSet<Integer>();
        int n = candyType.length;
        for (int i = 0; i < n; i++) {
            integers.add(candyType[i]);
        }
        return Math.min(integers.size(), n / 2);
    }
}
