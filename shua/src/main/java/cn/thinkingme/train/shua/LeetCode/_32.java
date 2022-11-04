package cn.thinkingme.train.shua.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _32
 * @Author: huige
 * @Description: 最长有效括号子串
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @Date: 2021/8/20 11:07
 * @Version: 1.0
 */
public class _32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses3("()())))"));
    }
    /**
     *
     */
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
    public static int longestValidParentheses3(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        boolean[][] dp = new boolean [n][n];
        for(int j = 1 ; j < n ; j++){
            for(int i = j-1; i >= 0 ; i--){
                if(s.charAt(i) == '('&& s.charAt(j) == ')' && j-i == 1){
                    dp[i][j] = true;
                    max = Math.max(max , j-i+1);
                }else if(s.charAt(i) == '('&& s.charAt(j) == ')' && dp[i+1][j-1]){
                    dp[i][j] = true;
                    max = Math.max(max , j-i+1);
                }
                else if( con(dp,i,j)){
                    dp[i][j] = true;
                    max = Math.max(max , j-i+1);
                }
            }
        }
        return  max;
    }
    public static boolean con(boolean dp[][], int i ,int j) {
        for(int x = i + 1 ;x < j ;x++){
            if(dp[i][x] && dp[x+1][j]){
                return true;
            }
        }
        return false;
    }
}
//(()(()))