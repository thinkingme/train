package com.thinkingme.train.shua.剑指;

/**
 * <p>
 * 剑指 Offer 11. 旋转数组的最小数字
 * </p>
 *
 * @author: huige
 * @date: 2022/8/30 15:46
 */
public class _1_11 {

    public int minArray(int[] numbers) {
        if (numbers.length == 1)return numbers[0];
        int left = numbers[0];
        int right = Integer.MAX_VALUE;
        for(int i = 1;i<numbers.length;i++){
            if(numbers[i] <numbers[i-1]){
                right = numbers[i];
            }
        }
        return Math.min(left,right);
    }
}
