package cn.thinkingme.train.shua.动态规划;

public class 最长公共子序列 {
	public static void main(String[] args) {
		LCS("s1", "s2");
	}
	public static int longestCommonSubsequence(String text1, String text2) {
		int a[][] = new int[text1.length()+1][text2.length()+1];
		for(int i = 1;i<=text1.length();i++) {
			for(int j =1;j<=text2.length();j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					a[i][j] =  a[i-1][j-1]+1; 
				}else {
					a[i][j] =  a[i][j] + Math.max(a[i][j-1],a[i-1][j]); 
				}
			}
		}
		
		return a[text1.length()][text2.length()];
    }
	public static String LCS (String s1, String s2) {
        int n1=s1.length(),n2=s2.length();
        String[][]dp=new String[n1+1][n2+1];//表示当处理到s1的第i个元素和s2的第j个元素时公共子序列的长度
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0||j==0) dp[i][j]="";
                else if(s1.charAt(i-1)==s2.charAt(j-1)){//如果相同的话
//                     dp[i][j]=dp[i-1][j-1]+1;
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);
                }
                else {
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        if(dp[n1][n2]=="") return "-1";
        return dp[n1][n2];
    }
}
