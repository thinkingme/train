package com.thinkingme.train.shua.LeetCode;

import java.util.PriorityQueue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _295
 * @Author: huige
 * @Description: 数据流的中位数
 *
 * @Date: 2021/8/27 11:18
 * @Version: 1.0
 */
public class _295 {
    //双堆顶
    PriorityQueue<Integer> min ;
    PriorityQueue<Integer> max ;
    /** initialize your data structure here. */
    public _295() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> {return  b - a ;});
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if (min.size() > max.size())
            max.add(min.remove());
    }

    public double findMedian() {
        if (max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        else
            return max.peek();
    }
}
