package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: 最小k个数
 * @Author: huige
 * @Description: 最小k个数
 * @Date: 2021/9/3 10:19
 * @Version: 1.0
 */
public class 最小k个数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
    public static int[] smallestK(int[] arr, int k) {
        partion(arr,0,arr.length-1,k);
        return  Arrays.copyOfRange(arr, 0, k);
    }

    private static void partion(int []arr,int min,int max,int k) {
        if(min > max) return;
        int left = min;
        int right = max;
        int random = new Random().nextInt(right - left+ 1) + left;
        swap(arr, random, left);
        int p = arr[left];
        while(left<right){
            while(left<right&&arr[right]>=p){
                right--;
            }
            arr[left] = arr[right];
            while(left<right&&arr[left]<=p){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = p;
        if(left == k ){
        }else if(left>k){
            partion(arr,min,left-1,k);
        }else{
            partion(arr,left+1,max,k);
        }
    }
    static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


}
