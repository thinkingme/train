package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _743
 * @Author: huige
 * @Description: 网络延迟时间
 * @Date: 2021/8/3 17:22
 * @Version: 1.0
 */
public class _743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;

        // 邻接矩阵存储边信息
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            // 边序号从 0 开始
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        // 从源点到某点的距离数组
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        // 由于从 k 开始，所以该点距离设为 0，也即源点
        dist[k - 1] = 0;

        // 节点是否被更新数组
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            // 在还未确定最短路的点中，寻找距离最小的点
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }

            // 用该点更新所有其他点的距离
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        // 找到距离最远的点
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
