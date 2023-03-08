package com.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * @author huige
 */
public class _560 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums,2));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>(1024);
        int res = 0,sum = 0;
        for (int i:nums){
            hashMap.put(sum,hashMap.getOrDefault(sum,0)+1);
            sum +=i;
            res += hashMap.getOrDefault(sum - k,0);
        }
        return res;
    }
}
