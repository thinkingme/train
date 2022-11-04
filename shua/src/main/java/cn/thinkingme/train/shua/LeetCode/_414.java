package cn.thinkingme.train.shua.LeetCode;

import java.util.PriorityQueue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _414
 * @Author: huige
 * @Description: 第三大的数
 * @Date: 2021/10/6 22:54
 * @Version: 1.0
 */
public class _414 {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2}));
    }
    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(integers.contains(nums[i]))continue;
            integers.add(nums[i]);
            if(integers.size()>3)integers.poll();
        }
        if(integers.size()<3){
            while(integers.size()>1){
                integers.poll();
            }
            return integers.poll();
        }
        return integers.poll();
    }
}
