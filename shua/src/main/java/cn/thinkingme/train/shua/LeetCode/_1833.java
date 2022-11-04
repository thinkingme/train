package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

public class _1833 {
	public static void main(String[] args) {
		int costs[] = {1,3,2,4,1};
		int coins = 7;
		System.out.println(maxIceCream(costs, coins));
	}
	public static int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int res = 0,i = 0;
		for (; i < costs.length; i++) {
			res += costs[i];
			if(res>coins) {
				break;
			}
		}
		return i;
    }
}
