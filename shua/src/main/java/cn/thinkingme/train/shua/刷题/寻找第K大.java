package cn.thinkingme.train.shua.刷题;

/**
 * 给定一个无序 数组 ，找寻第k大的数
 *
 * 可以利用快速排列的算法
 */
public class 寻找第K大 {
    /** 
    找出数组中第K大的数：表示要从大到小排，找到第k大的数字
    */
    public int findKth(int[] a, int n, int K) {
        int low = 0, high = n - 1;
        while(low <= high) {
            int i = low, j = high;
            //基准数
            int temp = a[low];
            while(i < j) {
                // 从右到左找到第一个 < temp 的数的下标
                while(i < j && a[j] <= temp) {
                    j--;
                }
                a[i] = a[j];
                while(i < j && a[i] >= temp){
                    i++;
                }
                a[j] = a[i];
            }
            //最后将基准为与i和j相等位置的数字交换
            a[i] = temp;
            if(i == K - 1){
                return a[K-1];
            }else if(i < K - 1) {
                // K-1 位于高分段
                low = i + 1;
            }else {
                // K-1 位于低分段
                high = i - 1;
            }
        }
        return -1;
    }
    /**
    交换下标为i，j的两个元素
    */
    private void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}