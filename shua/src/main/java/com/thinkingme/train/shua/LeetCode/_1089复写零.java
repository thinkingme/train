package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 1089. 复写零
 * </p>
 *
 * @author: huige
 * @date: 2022/6/17 15:45
 */
public class _1089复写零 {
    public static void main(String[] args) {

    }
    public void duplicateZeros(int[] arr) {
        int n = arr.length, i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) j++;
            i++; j++;
        }
        i--; j--;
        while (i >= 0) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0 && --j >= 0) arr[j] = 0;
            i--; j--;
        }
    }
}
