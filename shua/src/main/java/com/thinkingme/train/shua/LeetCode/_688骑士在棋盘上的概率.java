package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 688. 骑士在棋盘上的概率
 * </p>
 *
 * @author: huige
 * @date: 2022/2/17 10:21
 */
public class _688骑士在棋盘上的概率 {
    public static void main(String[] args) {
        knightProbability(3,2,0,0);
    }
    public static double knightProbability(int n, int k, int row, int column) {
        double total = Math.pow(8, k);
        Double[][][] cache = new Double[k + 1][n][n];
        double live = f(row, column, k, n, cache);
        return live / total;
    }

    public static double f(int x, int y, int k, int n, Double[][][] cache) {
        if (x < 0 || y < 0 || x > n - 1 || y > n - 1) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }

        if (cache[k][x][y] != null) {
            return cache[k][x][y];
        }

        double rs = 0;
        rs += f(x - 1, y - 2, k - 1, n, cache);
        rs += f(x - 1, y + 2, k - 1, n, cache);
        rs += f(x + 1, y - 2, k - 1, n, cache);
        rs += f(x + 1, y + 2, k - 1, n, cache);
        rs += f(x + 2, y - 1, k - 1, n, cache);
        rs += f(x - 2, y - 1, k - 1, n, cache);
        rs += f(x + 2, y + 1, k - 1, n, cache);
        rs += f(x - 2, y + 1, k - 1, n, cache);

        cache[k][x][y] = rs;

        return rs;
    }

}
