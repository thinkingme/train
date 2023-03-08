package com.thinkingme.train.shua.LeetCode;

public class _275 {
    public static void main(String[] args) {
        int citations[] = {0,0};
        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        int n =citations.length ,count = 1;
        if(citations[n-1] == 0)return 0;
        for(int i = n-1;i>=0;i--){
            if(count > citations[i]){
                break;
            }
            count++;
        }
        return  --count;
    }
}
