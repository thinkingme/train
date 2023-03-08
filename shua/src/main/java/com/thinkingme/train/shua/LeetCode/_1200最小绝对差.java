package com.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * <p>
 * 1200. 最小绝对差
 * </p>
 *
 * @author: huige
 * @date: 2022/7/4 11:14
 */
public class _1200最小绝对差 {
    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27}));
    }
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(arr[i+1]-arr[i],min);
        }

        for (int i = 0,j = 1; i < arr.length; i++) {
            if (i==j){
                j++;
            }
            while (j<arr.length){
                if(arr[j] - arr[i] < min){
                    j++;
                }else if(arr[j] - arr[i] == min){

                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);temp.add(arr[j]);
                    list.add(temp);
                    j++;

                    break;
                }else break;
            }


        }
        return list;

    }
}
