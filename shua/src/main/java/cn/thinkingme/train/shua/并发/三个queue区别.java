package cn.thinkingme.train.shua.并发;

import java.util.concurrent.*;

/**
 * @ProjectName: 题目代码
 * @Package: 并发
 * @ClassName: 三个queue区别
 * @Author: huige
 * @Description:
 * @Date: 2021/11/29 21:53
 * @Version: 1.0
 */
public class 三个queue区别 {
    public static void main(String[] args) {
        linkedQueue();
    }



    /**
     * LinkedBlockingQueue
     */
    private static void linkedQueue() {
        System.out.println("\n\n =======LinkedBlockingQueue====== \n\n");
        /**
         * 核心线程数先创建，满了就继续创建，直到最大线程数
         * 再满了就用存到队列，队列满了采用拒绝策略。
         * (1) 默认的ThreadPoolExecutor.AbortPolicy
         * 处理程序遭到拒绝将抛出运行时RejectedExecutionException;
         * (2) ThreadPoolExecutor.CallerRunsPolicy
         * 线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，(看源码应该是反复执行直到被运行)
         * 能够减缓新任务的提交速度
         * (3) ThreadPoolExecutor.DiscardPolicy
         * 不能执行的任务将被删除;
         * (4) ThreadPoolExecutor.DiscardOldestPolicy
         * 如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）。
         * 线程池默认会采用的是defaultHandler策略
         */
        Executor executors = new ThreadPoolExecutor(
                2, 3, 3, TimeUnit.SECONDS,
                //new LinkedBlockingQueue<Runnable>(2),
                //new SynchronousQueue<Runnable>(),
                new ArrayBlockingQueue<Runnable>(2),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        execute(executors);
    }


    private static void execute(Executor executors) {
        executors.execute(new NameRunnable(1));
        executors.execute(new NameRunnable(2));
        executors.execute(new NameRunnable(3));
//        executors.execute(new NameRunnable(4));
//        executors.execute(new NameRunnable(5));
//        executors.execute(new NameRunnable(6));
//        executors.execute(new NameRunnable(7));
//        executors.execute(new NameRunnable(8));
//        executors.execute(new NameRunnable(9));
//        executors.execute(new NameRunnable(10));
//        executors.execute(new NameRunnable(11));
//        executors.execute(new NameRunnable(12));
    }

    /***
     * 创建一个有名字的runnable对象
     */
    private static class RejectHandler implements RejectedExecutionHandler {


        public RejectHandler() {

        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task " + Thread.currentThread().getName());
        }
    }
}
class NameRunnable implements Runnable{
    private int name;

    public NameRunnable(int a){
        name=a;
    }

    @Override
    public void run() {
        try {
            System.out.println("task "+name+" is running Thread name is " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}