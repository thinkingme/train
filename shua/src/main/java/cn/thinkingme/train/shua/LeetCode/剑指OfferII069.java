package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: 剑指OfferII069
 * @Author: huige
 * @Description: 山峰数组的顶部
 * @Date: 2021/10/14 10:11
 * @Version: 1.0
 */
public class 剑指OfferII069 {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{2,1,0,55555,5,5,5,5,5}));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int now[] = new int[arr.length+2];
        int left = 0,right = arr.length-1;
        while(left<=right){
            int mid = left + ((right - left)>>1);
            if((mid + 1)<arr.length && arr[mid+1]>=arr[mid]){
                left = mid+1;
            }else if((mid - 1)>=0 && arr[mid-1]>=arr[mid]){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return 0;
    }
}
