package cn.thinkingme.train.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 小写排序 {
    public static void main(String[] args) {
        System.out.println(1L<<454645486);
        int a[] = {5,4,3,2,1,5,8,6};
        //quick_sort(a,0,a.length-1);
        heap_sort2(a);
        System.out.println(Arrays.toString(a));
    }
    public static void quick_sort(int a[],int left,int right){
       if(left >= right)return;
        int l = left ,r = right;
        int t = a[l];
        while(left < right){
            while(a[right] >= t && left<right){
                right--;
            }
            a[left] = a[right];
            while(a[left] <= t && left < right) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = t;
        quick_sort(a,l,left-1);
        quick_sort(a,left+1,r);
    }
    public static void heap_sort(int a[]){
        PriorityQueue<Integer> objects = new PriorityQueue<>();

        for(int i:a){
            objects.add(i);
        }
        while(objects.size()>0){
            System.out.println(objects.poll());
        }

    }
    //堆排序（大顶堆 | 升序）
    public static void heap_sort2(int a[]){
        //构造初始堆
        //完全二叉树最后一个非叶子节点的索引是n/2-1
        //从最后一个非叶子节点开始，逐步向上调整
        for(int i = a.length/2-1;i>=0;i--){
            heapify(a,a.length,i);
        }
        //后续
        //将堆顶元素与最后一个元素交换，并且重新调整堆
        for(int i = a.length-1;i>=0;i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a,i,0);
        }
    }
    public static void heapify(int a[],int n,int i){
        //i是父节点
        int l = 2*i+1;
        //i是父节点
        int r = 2*i+2;
        int largest = i;
        if(l<n && a[l]>a[largest]){
            largest = l;
        }
        if(r<n && a[r]>a[largest]){
            largest = r;
        }
        //如果父节点不是最大值，则交换
        if(largest!=i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            //递归 （因为此时下面的小堆可能不满足大顶堆，所以要进行调整）
            //递归的终止条件是父节点是最大值
            //递归的过程是将父节点和子节点进行比较，如果子节点比父节点大，则交换，并且递归
            heapify(a,n,largest);
        }
    }
    //冒泡排序
    public static void bubble_sort(int a[]){
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    //选择排序
    public static void select_sort(int a[]){
        for(int i = 0;i<a.length;i++){
            int min = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    //插入排序
    public static void insert_sort(int a[]){
        for(int i = 1;i<a.length;i++){
            int j = i;
            while(j>0 && a[j]<a[j-1]){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
            }
        }
    }
    //希尔排序
    public static void shell_sort(int a[]){
        int gap = a.length/2;
        while(gap>0){
            for(int i = gap;i<a.length;i++){
                int j = i;
                while(j>=gap && a[j]<a[j-gap]){
                    int temp = a[j];
                    a[j] = a[j-gap];
                    a[j-gap] = temp;
                    j-=gap;
                }
            }
            gap/=2;
        }
    }
    //归并排序
    public static void merge_sort(int a[]){
        merge_sort(a,0,a.length-1);
    }
    public static void merge_sort(int a[],int left,int right){
        if(left>=right)return;
        int mid = (left+right)/2;
        merge_sort(a,left,mid);
        merge_sort(a,mid+1,right);
        merge(a,left,mid,right);
    }
    public static void merge(int a[],int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int i = left,j = mid+1,k = 0;
        while(i<=mid && j<=right){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=right){
            temp[k++] = a[j++];
        }
        for(int m = 0;m<temp.length;m++){
            a[left+m] = temp[m];
        }
    }

}
