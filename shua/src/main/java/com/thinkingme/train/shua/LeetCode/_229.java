package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _229
 * @Author: huige
 * @Description: 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 用摩尔投票法，每三个不一样的进行消除，最后留下两个里面可能有真确答案
 * 在遍历一次看看是否满足
 * 超过n/3的数最多只能有两个
 * @Date: 2021/10/22 9:56
 * @Version: 1.0
 */
public class _229 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int elem1 = 0;
        int elem2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == elem1){
                sum1++;
            }else if (nums[i] == elem2){
                sum2++;
            }else if(sum1 == 0){
                elem1 = nums[i];
                sum1 = 1 ;
            }else if(sum2 == 0){
                elem2 = nums[i];
                sum2 = 1;
            }else{
                sum1--;
                sum2--;
            }
        }
        int count1 = 0,count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == elem1){
                count1++;
            }else if(nums[i] == elem2){
                count2++;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(count1>nums.length/3){
            arrayList.add(elem1);
        }
        if(count2>nums.length/3){
            arrayList.add(elem2);
        }
        return arrayList;
    }

}
