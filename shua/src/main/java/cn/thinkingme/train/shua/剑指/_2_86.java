package cn.thinkingme.train.shua.剑指;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 分割回文子字符串
 * </p>
 *
 * @author: huige
 * @date: 2022/9/19 11:55
 */
public class _2_86 {
    static boolean[][] f;
    static List<List<String>> tmp = new ArrayList<List<String>>();
    static List<String> ans = new ArrayList<String>();
    static int n;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(partition("google")));
    }

    public static String[][] partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        int rows = tmp.size();
        String[][] ret = new String[rows][];
        for (int i = 0; i < rows; ++i) {
            int cols = tmp.get(i).size();
            ret[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = tmp.get(i).get(j);
            }
        }
        return ret;
    }

    public static void dfs(String s, int i) {
        if (i == n) {
            tmp.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
