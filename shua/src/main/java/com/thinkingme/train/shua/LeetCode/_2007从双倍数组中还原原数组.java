package com.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * <p>
 * 2007. 从双倍数组中还原原数组
 * </p>
 *
 * @author: huige
 * @date: 2022/6/13 16:50
 */
public class _2007从双倍数组中还原原数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1, 2, 3, 2, 4, 6, 2, 4, 6, 4, 8, 12})));
    }
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[]{};
        // 保证较小数先遍历到，因为最小的数肯定是原始数组里的
        Arrays.sort(changed);
        Map<Integer, Integer> cache = new HashMap<>();
        int cnt = 0;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cache.getOrDefault(changed[i], 0) > 0) {
                // 当前元素作为双倍元素匹配
                cnt++;
                cache.put(changed[i], cache.get(changed[i]) - 1);
                resList.add(changed[i] / 2);
            } else {
                // 当前元素作为原始元素匹配
                cache.put(changed[i] * 2, cache.getOrDefault(changed[i] * 2, 0) + 1);
            }
        }
        if (cnt != n / 2) return new int[]{};
        int[] res = new int[n / 2];
        for (int i = 0; i < res.length; i++) res[i] = resList.get(i);
        return res;
    }
}
