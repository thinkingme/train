package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _787
 * @Author: huige
 * @Description: K站中转内最便宜的航班
 * @Date: 2021/8/24 9:11
 * @Version: 1.0
 */
public class _787 {

    public static void main(String[] args) {
        String s = "我爱你";
        Integer a = 2;Integer b = 2;Integer c = 3;Integer d = 3;Integer e = 321;Integer f = 321;Long g = 3L;
        System.out.println (c -= d) ;
        System.out.println(e == f);
        System.out.println (c -= (a + b) ) ;
        System.out.println(c.equals (a + b));
        System.out.println (g -= (a + b));
        System.out.println (g.equals (a + b) ) ;
        System.out.println(s.charAt(1));
        int[][] flights =
                        {{0,1,100},{1,2,100},{0,2,500}}
;
        System.out.println(findCheapestPrice(3,flights,0,2,0));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        Queue<int[]> queue = new LinkedList<>();
        int [][]graph = new int[n][n];
        for(int i = 0;i<flights.length;i++){
            graph[flights[i][0]][flights[i][1]] = flights[i][2];
        }

        queue.add(new int[]{src,0});
        // 表示src到i到最小价格
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        while(!queue.isEmpty() && k + 1 > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < n; j++) {
                    if(graph[cur[0]][j]>0){
                        int distance = cur[1] + graph[cur[0]][j];
                        // 剪枝1，小于 j 之前记录的最小值，且小于 dst 之前记录的最小值
                        if (distance < ans[j] && distance < ans[dst]) {
                            ans[j] = distance;
                            if(cur[0]!=dst){
                                queue.add(new int[]{j, distance});
                            }
                        }
                    }
                }
            }
            k--;
        }
        return ans[dst] == Integer.MAX_VALUE?-1:ans[dst];
    }
}
