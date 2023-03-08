package com.thinkingme.train.shua.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _496
 * @Author: huige
 * @Description: 下一个更大元素
 * @Date: 2021/10/26 15:42
 * @Version: 1.0
 */
public class _496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length -1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                map.put(nums2[i],nums2[stack.peek()]);
            }else{
                map.put(nums2[i],-1);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
