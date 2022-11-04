package cn.thinkingme.train.shua.刷题;

public class TheSameArray {
	public static boolean duplicate(int[] nums, int length, int[] duplication) {
	    if (nums == null || length <= 0)
	        return false;
	    for (int i = 0; i < length; i++) {
	        while (nums[i] != i) {
	            if (nums[i] == nums[nums[i]]) {
	                duplication[0] = nums[i];
	                return true;
	            }
	            swap(nums, i, nums[i]);
	        }
	    }
	    return false;
	}

	private static void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
	@SuppressWarnings("null")
	public static void main(String[] args) {
		int nums[]={2, 3, 1, 0, 2, 5};
		int duplication[] = new int[1];
		System.out.println(duplicate(nums,6,duplication));
		System.out.println(duplication[0]);
	}
}
