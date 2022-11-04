package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _42
 * @Author: huige
 * @Description: 接雨水
 * @Date: 2021/9/27 9:07
 * @Version: 1.0
 */
public class _42 {
/**
 * @Method
 * @Author linzhenhui
 * @Version  1.0
 * @Description 维护左右两个数组，分别是从左往右和从右往左当前最大的高度。数组长度为n+2，把左右两边的空位算上。
 * @Date 2021/9/27
 */
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];
        int sum = 0;
        for(int i = 1; i < n; ++i) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for(int i = n; i > 0; --i) {
            right[i] = Math.max(right[i + 1], height[i - 1]);
        }
        for(int i = 1; i < n; ++i) {
            int h = Math.min(left[i - 1], right[i + 1]);
            if (h > height[i - 1]) sum += h - height[i - 1];
        }
        return sum;
    }
}
