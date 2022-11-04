package cn.thinkingme.train.test;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/9/20 9:36
 */
public class fuzhi {
    public static void main(String[] args) {
        int []c = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(c));
        int[][] a = new int[][]{{1,2},{3,4}};
        int[][] b = new int[2][2];
        b = a;
        b[0][0] = 0;
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));
        System.out.println(1<<10);
    }
}
