package cn.thinkingme.train.shua.剑指;

/**
 * <p>
 * 剑指 Offer 12. 矩阵中的路径
 * </p>
 *
 * @author: huige
 * @date: 2022/8/31 17:24
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _1_12 {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
        "ABCB"));
    }

    static int[][] direct = {{1,0},{-1,0},{0,-1},{0,1}};
    static boolean res = false;
    public static boolean exist(char[][] board, String word) {
        int[][] vis = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    dfs(board,vis,word,i,j,0,new StringBuffer());
                }
//                for (int k = 0; k < vis.length; k++) {
//                    Arrays.fill(vis[i],0);
//                }
            }
        }
        return res;
    }

    public static void dfs(char[][] board,int [][]vis,String word,int x ,int y,int curIdex,StringBuffer s) {
        vis[x][y] = 1;
        if(board[x][y]==word.charAt(curIdex)){
            s.append(board[x][y]);
            if(word.equals(String.valueOf(s))){
                res = true;
                return;
            }
        }else {
            vis[x][y] = 0;
            return;
        }

        for (int i = 0; i < direct.length; i++) {
            int h = x + direct[i][0];
            int l = y + direct[i][1];
            if(l>=0&&l<board[0].length &&h>=0&&h<board.length ){
                if(vis[h][l] == 1){
                    continue;
                }
                dfs(board,vis,word, h,l,curIdex+1,s);
            }

        }
        s.deleteCharAt(s.length()-1);
        vis[x][y] = 0;
    }
}
