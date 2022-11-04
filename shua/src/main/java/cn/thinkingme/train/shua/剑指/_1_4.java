package cn.thinkingme.train.shua.剑指;

/**
 * <p>
 * 剑指 Offer 04. 二维数组中的查找
 * </p>
 *
 * @author: huige
 * @date: 2022/8/26 19:10
 */
public class _1_4 {

    public static void main(String[] args) {

        System.out.println(findNumberIn2DArray(new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}},55));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        //n：行数 m：列数
        int n = matrix.length,m = matrix[0].length;

        int x = 0, y = matrix[0].length-1;
        while(x<n && y>=0){
            int cur = matrix[x][y];
            if(cur>target){
                y--;

            }else if(cur<target){
                x++;
            }else{
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] nums, int n){
        int low = 0, high = nums.length-1;
        while(low<high){
            int mid = (low + high)>>1;
            if(nums[mid] >= n){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

}

