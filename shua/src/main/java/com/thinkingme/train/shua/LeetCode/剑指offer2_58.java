package com.thinkingme.train.shua.LeetCode;

import java.util.TreeMap;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: 剑指offer2_58
 * @Author: huige
 * @Description: 日程表
 * @Date: 2021/11/10 16:20
 * @Version: 1.0
 */
public class 剑指offer2_58 {
    class MyCalendar {
        TreeMap<Integer, Integer> calendar;

        MyCalendar() {
            calendar = new TreeMap();
        }

        public boolean book(int start, int end) {
            Integer prev = calendar.floorKey(start),//返回小于或者等于start的最大值，不存在则为null：
                    next = calendar.ceilingKey(start);//返回大于或者等于start的最小值，不存在则为null：
            if ((prev == null || calendar.get(prev) <= start) &&
                    (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }
            return false;
        }
    }

}
