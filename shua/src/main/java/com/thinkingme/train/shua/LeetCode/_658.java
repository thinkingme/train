package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 658. 找到 K 个最接近的元素
 * 二分查找 + 双指针
 * </p>
 *
 * @author: huige
 * @date: 2022/8/25 9:00
 */
public class _658 {

    public _658(_658 a){

    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,1,1,10,10,10},1,9));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
