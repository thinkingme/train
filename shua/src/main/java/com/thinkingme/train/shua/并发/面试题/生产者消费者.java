package com.thinkingme.train.shua.并发.面试题;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量的同步容器，实现get和put方法，并实现getCount方法，
 * 能够支持2个生产者线程和10个消费者线程之间的阻塞调用
 * 使用ReentrantLock实现
 */
abstract interface A{
	int i=0;
	 String getName() ;
     default void run() {
        System.out.println(getName() + " run" +i);
    }
}

public class 生产者消费者 {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    static List<Object> lists = new ArrayList<Object>();
    BlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);
    SynchronousQueue que = new SynchronousQueue();
    final Lock lock = new ReentrantLock();

    final Condition proLock = lock.newCondition();
    final Condition conLock = lock.newCondition();

    public void put(Object o) {
        try{
            lock.lock();
            while(queue.size() == 2){
                //生产者等待
                proLock.await();
            }
            System.out.println(Thread.currentThread().getName()+" 生产中...");
            Thread.sleep(2000);
            queue.put(o);
            System.out.println("生产者：" + Thread.currentThread().getName() + "生产商品");
            System.out.println("当前商品数："+queue.size());
            //通知消费者消费
            conLock.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public Object get() {
        try{
            lock.lock();
            while(queue.size() == 0){
                //消费者者等待
                conLock.await();
            }
            System.out.println(Thread.currentThread().getName()+" 消费中...");
            Thread.sleep(2000);
            Object o = queue.poll();
            System.out.println("消费者：" + Thread.currentThread().getName() + "消费商品");
            //通知生产者
            proLock.signalAll();
            return o;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    public int getCount() {
        return lists.size();
    }

    public static void main(String[] args) {
        生产者消费者 test2 = new 生产者消费者();
        //准备2个生产线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    test2.put(new Object());
                }
            }, "pro" + i).start();
        }
        //准备10个消费线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    test2.get();
                }
            }, "con" + i).start();
        }
    }
}