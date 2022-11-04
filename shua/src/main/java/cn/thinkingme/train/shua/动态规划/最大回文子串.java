package cn.thinkingme.train.shua.动态规划;

public class 最大回文子串 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaaa"));
	}
	public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        int left = 0;
        dp[0][0] = true;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans = Math.max(ans,j-i+1);
                    if(ans == j-i+1){
                        left = i;
                    }
                }
            }
        }
        return s.substring(left,left+ans);
    }
}
