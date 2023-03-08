package com.thinkingme.train.shua.刷题;

import java.util.Arrays;
import java.util.HashMap;

public class Sort {
	static int[] temp;
	public static void swap(int[] array, int a, int b) 
	{ 
		int temp = array[a]; 
		array[a] = array[b]; 
		array[b] = temp; 
	}
	public static void maopao(int a[]) {
		for(int i = 0;i<a.length;i++) {
			for(int j = 1;j<a.length-i;j++) {
				if(a[j-1]>a[j]) {
					swap(a, j-1, j);
				}
			}
		}
	}
	public static void xuanzhe(int a[]) {
		for(int i = 0;i<a.length;i++) {
			int min = i;
			for(int j = i+1;j<a.length;j++) {
				if(a[j]<a[min]) {
					min = j;
				}
			}
			swap(a, i ,min);
		}
	}
	/**
	 * 通过交换进行插入排序，借鉴冒泡排序
	 *
	 * @param a
	 */
	public static void charu(int[] a) {
	    for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i;
			for (; j > 0&&a[j-1] > temp; j--) {
				a[j] = a[j - 1];
	        }
			a[j] = temp;
		}
	}
	/**quick sort */
	public static void sort(int[] a, int low, int high) {
	    //已经排完
	    if (low >= high) {
	        return;
	    }
	    int left = low;
	    int right = high;

	    //保存基准值
	    int pivot = a[left];
	    while (left < right) {
	        //从后向前找到比基准小的元素
	        while (left < right && a[right] >= pivot)
	            right--;
	        a[left] = a[right];
	        //从前往后找到比基准大的元素
	        while (left < right && a[left] <= pivot)
	            left++;
	        a[right] = a[left];
	    }
	    // 放置基准值，准备分治递归快排
	    a[left] = pivot;
	    sort(a, low, left - 1);
	    sort(a, left + 1, high);
	}
	
	/** */
	public static void mergesort(int arr[],int low,int high) {
		// TODO Auto-generated method stub
		if(low>=high)return;
		int mid = low + ((high - low)>>1);
		mergesort(arr, low, mid);
		mergesort(arr, mid+1, high);
		merge(arr,low,mid,high);
	}
	public static void merge(int a[],int low,int mid,int high) {
		int j = mid +1;
		int i = low;
		int h = low;
		
		while(i<=mid && j<=high) {
			if(a[i]<=a[j]) {
				temp[h++] = a[i++];
			}else {
				temp[h++] = a[j++];
			}
		}
		while(j<=high) {
			temp[h++] = a[j++];
		}

		while(i<=mid) {
			temp[h++] = a[i++];
		}
		for(int x = low;x<=high;x++) {
			a[x] = temp[x];
		}
	}
	public static int reverse(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.parseInt(new StringBuffer(string).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }
    }
	
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		
		int array[]= {5,4,3,2,1,2,3,10,4,5};
		int string = -454456123;
		System.out.println(reverse(string));
		temp = new int[array.length];
		charu(array);
		//Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
