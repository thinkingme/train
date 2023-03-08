package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _50
 * @Author: huige
 * @Description: pow(x, n)
 * @Date: 2021/10/12 15:43
 * @Version: 1.0
 */
public class _50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,10));
    }
    public static double myPow(double x, int n) {
        long h = n;
        if(n<0) {
            h=-h;
            x = 1/x;
        }
        double base = x,res = 1;
        while(h>0) {
            if ((h & 1) == 1) {
                res = res * base;
            }
            base *= base;
            h >>= 1;
        }

        return res;
    }
}
