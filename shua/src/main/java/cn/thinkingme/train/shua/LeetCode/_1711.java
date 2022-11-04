package cn.thinkingme.train.shua.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1711 {
	public static Stack<Integer> stack = new Stack<>();
	public static int count;
	
	public static void main(String[] args) {
		Integer deliciousness[] = {1,1,1,3,3,3,7};
		Integer integer = 10000;
		Integer x[] = {10000,5};
		System.out.println(countPairs(deliciousness));
		System.out.println(integer == x[0]);
	}
	
	public static int countPairs(Integer[] deliciousness) {
		final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

}
