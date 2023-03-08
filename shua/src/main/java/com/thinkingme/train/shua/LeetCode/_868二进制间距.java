package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 868. 二进制间距
 * </p>
 *
 * @author: huige
 * @date: 2022/4/24 17:59
 */
public class _868二进制间距 {
    public static void main(String[] args) {

    }
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int max = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (last != -1) {
                    max = Math.max(max, i - last);
                }
                last = i;
            }
        }
        return max;
    }
}
