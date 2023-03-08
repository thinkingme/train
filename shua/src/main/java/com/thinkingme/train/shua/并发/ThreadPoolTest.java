package com.thinkingme.train.shua.并发;

import java.util.concurrent.*;

/**
 * <p>
 * 线程池bug测试
 * </p>
 *
 * @author: huige
 * @date: 2022/1/19 16:33
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        final ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        Future<String> future = threadPoolTest.submit();
                        try {
                            String s = future.get();
                            System.out.println(s);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (Error e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        //子线程不停gc，模拟偶发的gc
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.gc();
                }
            }
        }).start();
    }

    /**
     * 异步执行任务
     * @return
     */
    public Future<String> submit() {
        //关键点，通过Executors.newSingleThreadExecutor创建一个单线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(50);
                return System.currentTimeMillis() + "";
            }
        });
        executorService.execute(futureTask);
        //不加这一行会因为方法内联优化，从而把线程池gc掉了，而里面的线程还没执行完毕。jdk11中修复。
        return futureTask;
    }

}