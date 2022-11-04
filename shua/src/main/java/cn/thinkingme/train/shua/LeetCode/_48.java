package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _48
 * @Author: huige
 * @Description: 旋转图像
 * @Date: 2021/10/11 10:56
 * @Version: 1.0
 */
public class _48 {
    public static void main(String[] args) {
        int [][]a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(a));
        rotate(a);
        System.out.println(Arrays.deepToString(a));
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            int []temp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = temp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
