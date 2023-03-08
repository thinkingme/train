package com.thinkingme.train.shua.LeetCode;

import java.util.*;
public class _352 {
	public static void main(String[] args) {
		SummaryRanges obj = new SummaryRanges();
		obj.addNum(1);
		int[][] param_2 = obj.getIntervals();
		System.out.println(Arrays.deepToString(param_2));
		obj.addNum(3);
		int[][] param_3 = obj.getIntervals();
		System.out.println(Arrays.deepToString(param_3));
		obj.addNum(7);
		int[][] param_4 = obj.getIntervals();
		System.out.println(Arrays.deepToString(param_4));
		obj.addNum(2);
		int[][] param_5 = obj.getIntervals();
		System.out.println(Arrays.deepToString(param_5));
	}
}
class SummaryRanges<V> {
    private TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
        set.last();
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.lastEntry();
        Iterator<Integer> iterator = set.iterator();
        HashMap<String, Integer> sortedMap = new HashMap<String, Integer>();
    }

    public void addNum(int val) {
        set.add(val);
    }

    public int[][] getIntervals() {
        List<int[]> ret = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        // 逐个检查集合中相邻的两个元素
        int begin = iterator.next(), end = begin;
        while (iterator.hasNext()) {
            int t = iterator.next();
            // 通过比较下一个元素和当前 end 之差是不是1，看看是否需要开始新的区间
            if (t != end + 1) {
                // 如果需要更新的话，就先把当前区间放到返回值中，然后再重新开始新的区间
                ret.add(new int[]{begin, end});
                begin = t;
                end = begin;
            } else {
                // 否则的话，就更新当前区间的 end
                end = t;
            }
        }
        // 最后需要把剩余的区间放到返回值中
        ret.add(new int[]{begin, end});
        return ret.toArray(new int[ret.size()][]);
    }
}
