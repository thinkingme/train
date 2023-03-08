package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _881
 * @Author: huige
 * @Description: 救生艇
 * @Date: 2021/8/26 8:52
 * @Version: 1.0
 */
public class _881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10},50));
        System.out.println(dp(new int[]{2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10},50));
    }
    public static int numRescueBoats(int[] people, int limit) {
        int res = 0;
        int right = people.length - 1;
        int left = 0;
        Arrays.sort(people);
        while (left <= right) {
            if (left == right) {
                res++;      // 只剩下最后一个,直接一个走,结束
                break;
            }
            if (people[left] + people[right] > limit) {
                res++;
                right--;        // 先载最重的, 而且最小的也无法一起载,那么就最重的单独走
            }
            else {
                res++;
                right--;        // 最重的与最轻的一起走
                left++;
            }
        }
        return res;
    }
    public static int dp(int[] people, int limit){
        int n = people.length;
        int dp[][] = new int[n+1][limit+1];
        for(int i = 1;i<=n;i++) {//第i件物品
            for(int j = 1;j<=limit;j++) {//j重量时
                if(people[i-1]<=j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-people[i-1]]+1);
                }else {
                    dp[i][j] =dp[i-1][j];
                }
            }
            int x = 0;
        }
        return dp[n][limit];
    }
}
