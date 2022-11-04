package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _1894
 * @Author: huige
 * @Description: 找到需要补充粉笔的学生编号
 * @Date: 2021/9/10 11:25
 * @Version: 1.0
 */

public class _1894 {


    public static void main(String[] args) {

    }

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) {
            return 0;
        }
        for (int i = 1; i < n; ++i) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) {
                return i;
            }
        }

        k %= chalk[n - 1];
        return binarySearch(chalk, k);
    }
    //二分找第一个比目标大的数
    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
