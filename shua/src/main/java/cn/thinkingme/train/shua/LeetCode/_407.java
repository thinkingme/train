package cn.thinkingme.train.shua.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _407
 * @Author: huige
 * @Description: 接雨水 II
 * 先把最外围的一圈作为围栏，选择一个最低的围栏，如果这个围栏的邻节点都比它大，此围栏可删除,邻节点作为新的围栏；
 * 如果邻节点比它小，那么邻节点可储蓄的水为二者高度之差，此时在邻节点设置围栏，高度为当前围栏高度即可。
 * @Date: 2021/9/27 10:00
 * @Version: 1.0
 */
public class _407 {
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int trapRainWater(int[][] height) {
        int m = height.length, n = height[0].length, res = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> height[p[0]][p[1]]));
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
            queue.offer(new int[]{i, n - 1});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            queue.offer(new int[]{0, j});
            queue.offer(new int[]{m - 1, j});
            visited[0][j] = visited[m - 1][j] = true;
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int h = height[p[0]][p[1]];
            for (int[] d : DIRECTIONS) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                if (h > height[x][y]) {
                    res += h - height[x][y];
                    height[x][y] = h;
                }
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return res;
    }
}
