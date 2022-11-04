package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
/**
 * <p>
 * 532. 数组中的 k-diff 数对
 * </p>
 *
 * @author: huige
 * @date: 2022/6/16 11:02
 */
public class _532数组中的kdiff数对 {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{6,7,3,6,4,6,3,5,6,9}, 4));
    }

    /**
     * 双指针 + 排序+ hash判断是否存在
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs(int[] nums, int k) {
        int[] beu = Arrays.stream(nums).sorted().toArray();
        int n = beu.length;
        HashSet<Integer> dif = new HashSet<>();
        int ans = 0;
        for (int i = 0,j = 1; i < n; i++) {
            while(j < n && beu[j] - beu[i] < k) {
                j++;
            }
            if(j < n  && beu[j] - beu[i] ==  k){
                if(!dif.contains(beu[j] + beu[i]) ){
                    ans++;

                    dif.add(beu[j] + beu[i]);
                    j++;
                }

            }
            if(i == j-1){
                j++;
            }
        }
        return ans;
    }

    /**
     * 双指针 + 排序
     * 利用判断相邻位置是否相等来去重
     * @param nums
     * @param k
     * @return
     */
    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, y = 0, res = 0;
        for (int x = 0; x < n; x++) {
            if (x == 0 || nums[x] != nums[x - 1]) {
                while (y < n && (nums[y] < nums[x] + k || y <= x)) {
                    y++;
                }
                if (y < n && nums[y] == nums[x] + k) {
                    res++;
                }
            }
        }
        return res;
    }

}
