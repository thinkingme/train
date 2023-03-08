package com.thinkingme.train.shua.动态规划;

import java.util.Scanner;

public class _0_1背包 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int [] w = new int[6];//表示每件物品的重量
        int [] v = new int[6];//表示每件物品的价值
        for(int i=1;i<6;i++) {
            w[i] = scanner.nextInt();//输入重量
            v[i] = scanner.nextInt();//输入价值
        }
        int dp[][] = new int[6][9];
        for(int i = 1;i<6;i++) {//第i件物品
        	for(int j = 1;j<9;j++) {//j重量时
        		if(w[i]<=j) {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
        		}else {
        			dp[i][j] =dp[i-1][j];
        		}
        	}
        }
        for(int i=0;i<6;i++) {
            for(int j=0;j<9;j++) {
                System.out.printf("%-5d",dp[i][j]);
            }
            System.out.println();
        }
	}
}
