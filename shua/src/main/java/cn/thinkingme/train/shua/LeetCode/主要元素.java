package cn.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

public class 主要元素 {
    public static void main(String[] args) {
        int []nums = {1,2,5,9,5,9,5,5,5};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int max= 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i:nums){
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        for(int i:hs.keySet()){
            max = hs.get(i)>(nums.length>>1)?i:-1;
            if(max != -1)break;
        }
        return  max;
    }

    /**
     * 解题思路  摩尔投票法
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。
     * 最后还有人活下来的国家就是胜利。那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），
     * 或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。最后能剩下的必定是自己人。
     * //转自知乎
     */
    public int majorityElement2(int[] nums) {
        int major=nums[0],count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                major=nums[i];
                count=1;
                continue;
            }
            count = (nums[i]==major?count+1:count-1);
        }
        count = 0;
        for(int i:nums)
            if(i==major)
                count++;
        return count>nums.length/2?major:-1;
    }
}
