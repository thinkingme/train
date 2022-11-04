package cn.thinkingme.train.shua.LeetCode;

public class LCP07 {
	public static void main(String[] args) {
		
	}
	
	
	public static int numWays(int n, int[][] relation, int k) {
		boolean is_connected[][] = new boolean[n][n];
		for (int i = 0; i < relation.length; i++) {
			is_connected[relation[i][0]][relation[i][1]] = true;
		}
		return dfs(0 , is_connected,k);
		
    }


	private static int dfs(int src,boolean[][] is_connected, int k) {
		// TODO Auto-generated method stub
		if(k == 0) {
			return src == (is_connected.length-1)?1:0;
		}
		int res = 0;
		for (int i = 0; i < is_connected.length; i++) {
			if(is_connected[src][i]) {
				res = res +dfs(i, is_connected, k-1);
			}
			
		}
		return res;
	}
}
