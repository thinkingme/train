package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _1893
 * @Author: huige
 * @Description: leecode 1893
 * @Date: 2021/7/23 9:01
 * @Version: 1.0
 */
public class _1893 {
    public static void main(String[] args) {
        int[][] ranges = {{36,50},{14,28},{4,31},{24,37},{13,36},{27,33},{23,32},{23,27},{1,35}};
        System.out.println(isCovered(ranges , 35,40));
    }
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        int[] res = new int[52];
        for(int a[]:ranges){
            diff[a[0]]++;diff[a[1]+1]--;
        }
        for(int i = 1;i<diff.length;i++){
            res[i] = res[i-1] + diff[i];
        }
        for(int i = left; i <= right; i++){
            if(res[i] <= 0){
                return false;
            }
        }
        return true;
    }

}
