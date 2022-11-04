package cn.thinkingme.train.shua.并查集;

import java.util.HashSet;
import java.util.Set;

public class 最长连续子序列 {
	class Solution {
	    public int longestConsecutive(int[] nums) {
	        Set<Integer> numsSet = new HashSet<>();
	        for (Integer num : nums) {
	            numsSet.add(num);
	        }
	        int longest = 0;
	        for (Integer num : nums) {
	            if (numsSet.remove(num)) {
	                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
	                int currentLongest = 1;
	                int current = num;
	                while (numsSet.remove(current - 1)) current--;
	                currentLongest += (num - current);
			// 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
	                current = num;
	                while(numsSet.remove(current + 1)) current++;
	                currentLongest += (current - num);
	        	// 搜索完后更新longest.
	                longest = Math.max(longest, currentLongest);
	            }
	        }
	        return longest;
	    }
	}
}
