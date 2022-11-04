package cn.thinkingme.train.test;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/4/6 16:19
 */
public class Hello {
    static class Test {
        public static void main(String[] args) {
            System.out.println("hello world");
        }

        int calculateDaysBetweenDates(int year1, int month1, int day1, int year2, int month2, int day2) {
            // Write your code here
            int days = 0;
            if (year1 == year2) {
                days = day2 - day1;
            } else {
                days = (year2 - year1) * 365 + (month2 - month1) * 30 + (day2 - day1);
            }
            return days;
        }

        public List<Integer> findMinHeightTrees(int n, int[][] edges) { // 时间复杂度O(n^2)
            if (n == 1) {
                return Collections.singletonList(0);
            }
            List<Integer>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (graph[i].size() == 1) {
                    leaves.add(i);
                }
            }
            while (n > 2) {
                n -= leaves.size();
                List<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    int neighbor = graph[leaf].get(0);
                    graph[neighbor].remove((Integer) leaf);
                    if (graph[neighbor].size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }
                leaves = newLeaves;
            }
            return leaves;
        }
    }

}
