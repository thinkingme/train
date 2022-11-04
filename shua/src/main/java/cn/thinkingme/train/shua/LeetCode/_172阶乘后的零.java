package cn.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 172. 阶乘后的零
 * </p>
 *
 * @author: huige
 * @date: 2022/3/25 9:03
 */
public class _172阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }
    public static int trailingZeroes(int n) {
        int res = 0;
        for (int i = 1; i < n+1; i++) {
            if((int)Math.pow(5,i) > n){
                break;
            }
            res+=n/(int)Math.pow(5,i);
        }
        return res;
    }
}
