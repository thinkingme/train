package com.thinkingme.train.shua.刷题;

public class Erweishuzhuzhongdechazhao {
    public static boolean Find(int [][] array,int target) {
         
        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                    low=mid+1;
                else if(target<array[i][mid])
                    high=mid-1;
                else
                    return true;
            }
        }
        return false;
 
    }
	public static void main(String[] args) {
		int a[][]= {
					{1,   4,  7, 11, 15},
		           {2,   5,  8, 12, 19},
		           {3,   6,  9, 16, 22},
		           {10, 13, 14, 17, 24},
		           {18, 21, 23, 26, 30}
				};
		System.out.println(Find(a, 9));
	}
}
