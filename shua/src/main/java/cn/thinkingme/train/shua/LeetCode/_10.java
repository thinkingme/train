package cn.thinkingme.train.shua.LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class _10 {
    public static void main(String[] args) {
        System.out.println(isMatch2("aaaa","a*"));
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean f[][] = new boolean[m + 1][n + 1];
        f[0][0] = true;//f[0][0]代表s和p均为空字符串，f[1][1]代表s和p的第一个字符（即在s和p中下标为0的字符）
        for(int i = 0; i <= m ; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(p.charAt(j - 1) == '*') {//p的第j个字符为*
                    if(matches(s, p, i, j - 1)) {//匹配s的第i个字符和p的第j-1个字符
                        f[i][j] = f[i - 1][j] || f[i][j - 2];//p中*前面的字符在s中出现多次或者在s中只出现1次
                    }
                    else {
                        f[i][j] = f[i][j - 2];//p中*前面的在s中字符出现0次
                    }
                }
                else {//p的第j个字符不为*
                    if(matches(s, p, i, j)) {//匹配s的第i个字符和p的第j个字符
                        f[i][j] = f[i - 1][j - 1];//匹配成功，状态转移；匹配不成功，默认是false
                    }
                }
            }
        }
        return f[m][n];
    }

    private static boolean matches(String s, String p, int i, int j) {//注意在字符串中的下标变换
        if(i == 0) {
            return false;
        }
        if(p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     *
     */
    public static boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; // here's y axis should be i+1
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                        /*
                        dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                        or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                        or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                            */

                    }
                }
            }
        }

        int count = 2;
        final LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(10, 1, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 10;
            }
        };
        return dp[s.length()][p.length()];
    }
}
