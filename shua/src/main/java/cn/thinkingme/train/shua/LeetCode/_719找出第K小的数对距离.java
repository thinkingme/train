package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * <p>
 * 719. 找出第 K 小的数对距离
 * </p>
 * 第k大   排列组合
 * @author: huige
 * @date: 2022/6/15 13:33
 */
public class _719找出第K小的数对距离 {
    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18));
    }

    /**
     * 二分答案 + 双指针 check 运用题 排序
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    static int check(int[] nums, int x) {
        int n = nums.length, ans = 0;
        for (int i = 0, j = 1; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= x) j++;
            ans += j - i - 1;
        }
        return ans;
    }

    /**
     * 暴力
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair2(int[] nums, int k) {
        int count[]=new int[(int)1e6+5];
        for(int i=0;i<nums.length;i++){for(int j=i+1;j<nums.length;j++){count[Math.abs(nums[i]-nums[j])]++;}}
        for(int i=0;;i++){
            k-=count[i];
            if(k<=0){return i;}
        }
    }

}
