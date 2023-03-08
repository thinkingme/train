package com.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * <p>
 * 1380. 矩阵中的幸运数
 * </p>
 *
 * @author: huige
 * @date: 2022/2/15 10:05
 */
public class _1380矩阵中的幸运数 {
    public static void main(String[] args) {
        int [][] matrix = new int[][]{{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        Arrays.fill(rows, Integer.MAX_VALUE);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                rows[i] = Math.min(cur, rows[i]);
                cols[j] = Math.max(cur, cols[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                if (cur == rows[i] && cur == cols[j]) {
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
