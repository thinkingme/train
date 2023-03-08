package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * <p>
 * 游戏中弱角色的数量
 * </p>
 *
 * @author: huige
 * @date: 2022/1/28 9:27
 */
public class _1996游戏中弱角色的数量 {
    public static void main(String[] args) {
        System.out.println(numberOfWeakCharacters(new int[][]{{1,5},{10,4},{4,3}}));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(o1, o2)->o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        int cnt=0;
        int max=-1;
        int n=properties.length;
        for(int i=0;i<n;i++){
            if(max>properties[i][1]){
                cnt++;
            }
            max=Math.max(max,properties[i][1]);

        }
        return cnt;
    }
}
