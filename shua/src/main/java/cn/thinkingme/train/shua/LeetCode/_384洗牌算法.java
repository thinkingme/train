package cn.thinkingme.train.shua.LeetCode;

import java.util.Random;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _384洗牌算法
 * @Author: huige
 * @Description: 打乱数组
 * @Date: 2021/11/22 9:23
 * @Version: 1.0
 */
public class _384洗牌算法 {
    class Solution {
        int[] nums;
        int n;
        Random random = new Random();
        public Solution(int[] _nums) {
            nums = _nums;
            n = nums.length;
        }
        public int[] reset() {
            return nums;
        }
        public int[] shuffle() {
            int[] ans = nums.clone();
            for (int i = 0; i < n; i++) {
                swap(ans, i, i + random.nextInt(n - i));
            }
            return ans;
        }
        void swap(int[] arr, int i, int j) {
            int c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }
}
