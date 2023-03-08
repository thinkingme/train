package com.thinkingme.train.shua.并发;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Double.NaN;

/**
 * @ProjectName: 题目代码
 * @Package: 并发
 * @ClassName: CompletableFutureTest
 * @Author: huige
 * @Description: CompletableFuture测试
 * @Date: 2021/9/15 13:53
 * @Version: 1.0
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f = CompletableFuture.supplyAsync(() ->{
                    return "先走一步";
            }
        );
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() ->{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "hello";
                }
        );
        // f2依赖f1的结果做转换
        CompletableFuture<String> f2 = f1.thenApplyAsync(t ->
        {
            System.out.println("异步结果:" + t);
            return "";
        });
        double comprehensiveScore = NaN;
        System.out.println(Double.isNaN(comprehensiveScore) ? 0 : Double.parseDouble(String.format("%.2f",comprehensiveScore)));

        while (true);
        //System.out.println("异步结果:" + f.get());

    }



}
