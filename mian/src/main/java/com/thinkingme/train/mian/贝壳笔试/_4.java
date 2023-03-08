package com.thinkingme.train.mian.贝壳笔试;

import java.util.*;
// 3 21 30
/*
一袋水果，给了每个水果的重量。
K次查询，每次查询给出一个s，问是否满足所有水果的重量等于s；
每次查询独立。
若不满足条件，可以从以下两个策略选择：
1 把所有重量超过平均数的水果扔掉；
2 把所有重量小于等于平均数的水果扔掉；
问是否可以通过执行若干次策略使条件满足。

这道题的难点在于k的范围<=10^5;
水果的数量也是这个范围

我的傻瓜策略就是迭代，当前重量如果大于s，就执行策略1；否则策略2；
这个方法肯定是错误的，比如 6 5 5 1 2，我要拿2，但结果只剩了1，所以不对。
显然傻瓜策略的时间复杂度会爆掉。
 */
public class _4 {
	public static int flag = 0;
	public static void main(String[] args) {
		/**
		 * 递归法
		 */
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();
		int a[] = new int[n];
		for(int i = 0;i<n;i++) {
			a[i] = scn.nextInt();
		}
		Arrays.sort(a);
		for(int i = 0;i<q;i++) {
			int target = scn.nextInt();
			int s = 0,e = a.length-1;
			dfs(a, target, s, e);
			if(flag == 0)System.out.print("NO");
		}
	}
	private static void dfs(int a[],int target,int s,int e) {
		if(s>=e)return;
		int sum = calc(a, s, e);
		if(sum == target) {
			System.out.print("YES");
			flag = 1;
			return;
		}
		int ave = sum/(e-s+1);
		int mid = find(a, s, e, ave);
		if(mid==-1) {
			return;
		}
		dfs(a, target, s, mid-1);
		dfs(a, target, mid, e);
		
	}
	private static int  find(int a[] , int s , int e ,int val) {
		for(int i  = s; i <= e;i++) {
			if(a[i] > val) return i;
		}
		return -1;
	}
	private static int  calc(int a[] , int s , int e) {
		int res = 0;
		for(int i  = s; i <= e;i++) {
			res +=a[i];
		}
		return res;
	}
	
	
	/**
	 * 模拟+二分+前缀和
	 */
	static void beike4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        long[] f = new long[n], pre = new long[n];
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
            memo.put(i, new HashMap<>());
        }

        Arrays.sort(f);
        for (int i = 0; i < n; i++) {
            pre[i] += f[i];
            pre[i] += i - 1 >= 0 ? pre[i - 1] : 0;

        }
//        SegmentTree segmentTree = new SegmentTree(f);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, f.length - 1});
        Set<Long> set = new HashSet<>();
        set.add(0L);
        while (queue.size() > 0) {
            int[] a = queue.poll();
            int l = a[0], r = a[1];
            long sum = getSum(pre, l, r);
            set.add(sum);

            long avg = sum / (r - l + 1);
            if (f[l] == avg && f[r] == avg) {
                continue;
            }
            int idx = upperBound(f, avg, l, r);
            if (memo.get(l).get(idx) == null) {
                queue.add(new int[]{l, idx});
                memo.get(l).put(idx, 0);
            }
            if (memo.get(idx + 1).get(r) == null) {
//                queue.add(new int[]{l,
                queue.add(new int[]{idx + 1, r});
                memo.get(idx + 1).put(r, 0);

            }
        }

//        System.out.println(set.size());

        for (int i = 0; i < q; i++) {
            long num = scanner.nextInt();
            System.out.println(set.contains(num) ? "YES" : "NO");
        }
    }

    static long getSum(long[] f, int l, int r) {
        return l == 0 ? f[r] : f[r] - f[l-1];
    }


    static int upperBound(long[] f, long num, int l, int r) {
//        int l = 0, r = f.length - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (f[mid] <= num) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (f[l+1] <= num) {
            l++;
        }
        return l;
    }
}
