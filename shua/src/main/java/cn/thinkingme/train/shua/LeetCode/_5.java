package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _5
 * @Author: huige
 * @Description: 最长回文子串
 * @Date: 2021/11/17 9:43
 * @Version: 1.0
 */
public class _5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean isp[][] = new boolean[n][n];
        int left= 0 , right = 0;
        int max = 0 ;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if(s.charAt(i) == s.charAt(j)&& (j - i < 2 || isp[i+1][j-1])){
                    isp[i][j] = true;
                    if( max < j - i ){
                        max = j-i;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left,right+1);
    }
}
