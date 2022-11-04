package cn.thinkingme.train.shua.LeetCode;

import java.util.*;

public class _349 {

}
/**class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					set.add(nums1[i]);
				}
			}
		} 
		
		Object[] aObject = set.toArray();
		int[] temp = new int[aObject.length];
		for (int i = 0; i < aObject.length; i++) {
            temp[i] = (int) aObject[i];//将Object对象数组转为整型数组（强制向下转型）
            System.out.print(temp[i] + " ");
        }
    	return temp;
    }
}**/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int item : nums1) {
            set1.add(item);
        }

        for (int item : nums2) {
            if (set1.contains(item)) {
                set2.add(item);
            }
        }

        int[] result = new int[set2.size()];
        int start = 0;
        for (int item : set2) {
            result[start] = item;
            start++;
        }
        return result;
    }
}
