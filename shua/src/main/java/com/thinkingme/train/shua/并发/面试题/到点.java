package com.thinkingme.train.shua.并发.面试题;

/**
 * @ProjectName: 题目代码
 * @Package: 并发.面试题
 * @ClassName: 到点
 * @Author: huige
 * @Description:当一个线程计数到5的时候，唤醒另一个线程继续执行后，再回来继续
 * @Date: 2021/10/19 20:44
 * @Version: 1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 到点 {
    ThreadLocal threadLocal = new ThreadLocal<Integer>();
    static List<Object> lists = new ArrayList<Object>();
    static  Lock lock = new ReentrantLock();
    static Object lo = new Object();

    static  Condition proLock = lock.newCondition();
    static  Condition conLock = lock.newCondition();

    public int getCount() {
        return lists.size();
    }


    public static void main(String[] args) {
        /**
         * join 方法
         */
        Thread A = new Thread(()->{
            System.out.println("A来了");
        }, "A");
        new Thread(()->{
            try{

                for (int i = 0; i < 100; i++) {
                    System.out.println("第"+i);
                    if( i == 50){

                        A.start();
                        A.join();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        /**
         * 加锁方法
         */
        ArrayList<Object> objects = new ArrayList<>();
        new Thread(()->{
            new Thread(()->{
                synchronized(lo) {
                    if(objects.size() != 5){
                        try {
                            lo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("c来了");
                    lo.notifyAll();
                }

            }, "c").start();
            synchronized(lo){
                for (int i = 0; i < 100; i++) {
                    System.out.println("第d"+i);
                    objects.add(new Object());
                    if( objects.size() == 5){
                        lo.notifyAll();
                        try {
                            lo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, "D").start();





    }
}