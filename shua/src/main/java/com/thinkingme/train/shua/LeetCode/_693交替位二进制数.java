package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 693. 交替位二进制数
 * </p>
 *
 * @author: huige
 * @date: 2022/3/28 9:21
 */
public class _693交替位二进制数 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(11));
    }
    public static boolean hasAlternatingBits(int n) {
        int next = 0;
        if(n%2 == 0){
            next = 1;
        }else if(n%2 == 1){
            next = 0;
        }
        while(n>0){
            n/=2;
            if(n%2 != next){
                return false;
            }
            if(n%2 == 0){
                next = 1;
            }else if(n%2 == 1){
                next = 0;
            }
        }
        return true;
    }
}
