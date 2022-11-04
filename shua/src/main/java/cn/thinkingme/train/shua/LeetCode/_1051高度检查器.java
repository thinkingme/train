package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * <p>
 * 高度检查器
 * </p>
 *
 * @author: huige
 * @date: 2022/6/13 16:42
 */
public class _1051高度检查器 {

    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }
        return count;
    }
}
