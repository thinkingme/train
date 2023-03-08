package com.thinkingme.train.shua.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _847
 * @Author: huige
 * @Description: 访问所有节点的最短路径
 * @Date: 2021/8/6 16:44
 * @Version: 1.0
 */
public class _847 {

    public static void main(String[] args) {
        int [][]graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        shortestPathLength(graph);
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }
}


/**
 * @Method 默写上面代码环节
 * @Author linzhenhui
 * @Version  1.0
 * @Description
 * @Param
 * @Return
 * @Exception
 * @Date 2021/8/9
 */
class Copy{
    public static void main(String[] args) {
        int [][]graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        System.out.println(shortestPathLength(graph));
    }
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> ints = new LinkedList<>();
        boolean seens[][]=new boolean[n][1<<n];
        for(int i = 0;i<n;i++){
            ints.add(new int[]{i,1<<i,0});
            seens[i][1<<i] = true;
        }
        while(!ints.isEmpty()){
            int []cur = ints.poll();
            int v = cur[0],mask = cur[1],dirt = cur[2];
            if(mask == (1<<n) -1){
                return dirt;
            }
            for(int u:graph[v]){
                int maskV = mask | (1<<u);
                if(!seens[u][maskV]){
                    ints.add(new int[]{u,maskV,dirt+1});
                    seens[u][maskV] = true;
                }
            }
        }
        return 0;
    }
}
