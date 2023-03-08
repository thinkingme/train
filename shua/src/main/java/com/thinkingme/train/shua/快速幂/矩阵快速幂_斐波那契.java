package com.thinkingme.train.shua.快速幂;

public class 矩阵快速幂_斐波那契 {
	public static void main(String[] args) {
		System.out.println(quick_pow(6));
	}
	
	private static int quick_pow(int sum) {
		int res[][] = {{1,1},{1,1}};
		int base[][] = {{1,1},{1,0}};
		
		while(sum > 0) {
			if((sum&1) == 1 ) {
				res = multipe(res, base);
			}
			base = multipe(base, base);
			sum = sum>>1;
		}
		return res[0][1];
	}
	
	public static int[][] multipe(int a[][],int b[][]) {
		int m = a.length,n = b[0].length,t = a[0].length;
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int x = 0; x < t; x++) {
					res[i][j] += a[i][x]*b[x][j]; 
				}
			}
		}
		return res;
	}
}
