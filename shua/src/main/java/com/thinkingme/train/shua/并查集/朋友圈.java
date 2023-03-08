package com.thinkingme.train.shua.并查集;

import java.util.Arrays;

/**
 * 题目描述
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果 M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
力扣：547 朋友圈

输入：
[[1,1,0],
[1,1,0],
[0,0,1]]
输出：2
解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回 2 。
————————————————
版权声明：本文为CSDN博主「ZhangyiA*」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_42479017/article/details/110818025
 * @author Administrator
 *
 */
public class 朋友圈 {

	class Solution {

	    // 如果是第一次出现，自己是自己的 parent 否则递归查找父亲，返回父亲节点
	    public int find(int[] parent, int i) {
	        return parent[i] == -1 ? i : find(parent , parent[i]);
	    }

	    public void union(int[] parent , int x , int y){
	        int x_parent = find(parent , x);
	        int y_parent = find(parent , y);
	        if(x_parent != y_parent){
	            parent[x_parent] = y_parent; 
	        }
	    }

	    public int findCircleNum(int[][] M) {
	        int[] parent = new int[M.length];
	        Arrays.fill(parent , -1);
	        for(int i = 0 ; i < M.length ; i ++){
	            for(int j = 0 ; j < M[0].length ; j ++){
	                if(M[i][j] == 1 && i != j){
	                    union(parent , i , j);
	                }
	            }
	        }
	        int count = 0;
	        for(int i = 0 ; i < parent.length ; i ++){
	            // 只有单独自身的是独立的朋友圈
	            if(parent[i] == -1) count ++;
	        }
	        return count;
	    }
	}

}
