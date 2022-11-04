package cn.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 440. 字典序的第K小数字
 * </p>
 *
 * @author: huige
 * @date: 2022/3/23 9:45
 */
public class _440字典序的第K小数字 {
    class Solution {
        public int findKthNumber(int n, int k) {
            int ans = 1;
            while (k > 1) {
                int cnt = getSteps(ans, n);
                if (cnt < k) {
                    k -= cnt; ans++;
                } else {
                    k--; ans *= 10;
                }
            }
            return ans;
        }
        int getCnt(int x, int limit) {
            String a = String.valueOf(x), b = String.valueOf(limit);
            int n = a.length(), m = b.length(), k = m - n;
            int ans = 0, u = Integer.parseInt(b.substring(0, n));
            for (int i = 0; i < k; i++) ans += Math.pow(10, i);
            if (u > x) ans += Math.pow(10, k);
            else if (u == x) ans += limit - x * Math.pow(10, k) + 1;
            return ans;
        }
        public int getSteps(int curr, long n) {
            int steps = 0;
            long first = curr;
            long last = curr;
            while (first <= n) {
                steps += Math.min(last, n) - first + 1;
                first = first * 10;
                last = last * 10 + 9;
            }
            return steps;
        }
    }

}
