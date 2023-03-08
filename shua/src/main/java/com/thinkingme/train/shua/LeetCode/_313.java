package com.thinkingme.train.shua.LeetCode;

import java.util.PriorityQueue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _313
 * @Author: huige
 * @Description: 超级丑数
 * @Date: 2021/8/9 10:35
 * @Version: 1.0
 */
public class _313 {
    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue=new PriorityQueue<>();
        long res=1;
        for(int i=1;i<n;i++){
            for(int prime:primes){
                queue.add(prime*res);
            }
            res=queue.poll();
            while(!queue.isEmpty()&&res==queue.peek()) queue.poll();
        }
        return (int)res;
    }

}
