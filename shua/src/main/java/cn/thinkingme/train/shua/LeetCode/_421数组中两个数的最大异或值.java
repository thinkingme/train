package cn.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 421. 数组中两个数的最大异或值
 * tips: 字典树
 * </p>
 *
 * @author: huige
 * @date: 2022/8/24 14:26
 */
public class _421数组中两个数的最大异或值 {
    BinTree root = new BinTree();

    int HIGH_BIT = 30;

    class BinTree{
        //代表 bit 0
        BinTree left;
        //代表 bit 1
        BinTree right;
    }


    public int findMaximumXOR(int[] nums) {
        BinTree root = new BinTree();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            max = Math.max(max,check(nums[i]));
        }
        return max;
    }
    public void add(int num) {
        BinTree cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new BinTree();
                }
                cur = cur.left;
            }
            else {
                if (cur.right == null) {
                    cur.right = new BinTree();
                }
                cur = cur.right;
            }
        }
    }
    public int check(int num) {
        BinTree cur = root;
        int res = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.right != null) {
                    res+=Math.pow(2,k);
                    cur = cur.right;
                }else{
                    cur = cur.left;
                }

            }
            else {
                if (cur.left != null) {
                    res+=Math.pow(2,k);
                    cur = cur.left;
                }else{
                    cur = cur.right;
                }

            }
        }
        return res;
    }
}
