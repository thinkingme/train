package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * <p>
 * 1464. 数组中两元素的最大乘积
 * </p>
 *
 * @author: huige
 * @date: 2022/8/26 8:50
 */
public class _1464 {
    public int maxProduct(int[] nums) {
        int i = 0,j = 0;
        int max = 0;
        for (int k = 0; k < nums.length; k++) {
            if(nums[k]>max){
                i = k;
                max = nums[k];
            }
        }
        max = 0;
        for (int k = 0; k < nums.length; k++) {
            if(nums[k]>max && k!=i){
                j = k;
                max = nums[k];
            }
        }
        return (nums[i]-1)*(nums[j]-1);
    }
}
