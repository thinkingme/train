package cn.thinkingme.train.shua.TestCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class String{
	public void name() {
		System.out.println("自定义string");
	}
}
public class Sort {
	public static void main(java.lang.String[] args) {
		Integer a[]= {5,4,3,2,1,1,5,5,10,5,6,7,8,10,10};
		ArrayList<Integer> arrayList = new ArrayList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Integer i,Integer j)->{
			return j-i;
		
		}) ;
		List<Integer> asList = Arrays.asList(a);
		new String().name();
		priorityQueue.addAll(asList);
		while(!priorityQueue.isEmpty())
		System.out.println(priorityQueue.poll());
	}
	
	
	public static void quickSort(int a[],int low,int high) {
		if(low >= high)return;
		int left = low;
		int right = high;
		int mid = a[left];
		while(left<right){
			while(left<right&&a[right]>=mid) {
				right--;
			}
			a[left] =a[right];
			while(left<right&&a[left]<=mid) {
				left++;
			}
			a[right] = a[left];
		}
		a[left] = mid;
		quickSort(a, low, left - 1);
		quickSort(a, left +1, high);
	}
}
