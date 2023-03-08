package com.thinkingme.train.shua.剑指;

/**
 * <p>
 * 二进制中1的个数
 * </p>
 *
 * @author: huige
 * @date: 2022/11/29 10:45
 */
public class _1_15二进制中1的个数 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
        System.out.println(test54(54));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int res = 0;
        while (n!=0){
            if((n&1)==1){
                res++;
            }
            n>>>=1;
        }
        return res;
    }
    public static int test54(int n) {
        try {
            return 2;
        }finally {
            System.out.println(1212);
        }
    }
}
