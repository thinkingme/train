package com.thinkingme.train.shua.LeetCode;
/**
 * 815. 公交路线
给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，
第 i 辆公交车将会在上面循环行驶。
例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列
 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * @author huige
 *
 */
import java.util.*;
public class _815 {
	public static void main(String[] args) {
		int[][] routes = {{1,2,7},{3,6,7}};
		int source = 1;
		int target = 6;
		System.out.println(numBusesToDestination(routes, source, target));
	}
	public static int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) {
            return 0;
        }
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
		int n = routes.length;
        boolean[][] edge = new boolean[n][n];
		for (int i = 0; i < routes.length; i++) {
			for(int t:routes[i]) {
				ArrayList<Integer> list = hashMap.getOrDefault(t, new ArrayList<Integer>());
				for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
				list.add(i);
				hashMap.put(t, list);
			}
		}
		int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int bus : hashMap.getOrDefault(source, new ArrayList<Integer>())) {
            dis[bus] = 1;
            que.offer(bus);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus : hashMap.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;

    }
}














