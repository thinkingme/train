package com.thinkingme.train.shua.LeetCode._1447;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 1447. 最简分数
 * </p>
 *
 * @author: huige
 * @date: 2022/2/10 14:34
 */
public class 最简分数 {
    int gcd(int a, int b) { // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) ans.add(i + "/" + j);
            }
        }
        return ans;
    }
}
