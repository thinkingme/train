package com.mashibing.juc.interrupt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 由于futureTask中有个cancel()方法，可以用于中断任务，而其底层调用的是Thread。interrupt()
 * 所以这里测试下哪些场景会被中断，
 * 测试后可以发现，有抛出InterruptedException的方法才可以被中断
 * 诸如synchronized等待锁，io阻塞等，是不可以被中断的，wait(),Thread.sleep(),lock.lockInterruptibly()是可以被中断的
 * </p>
 *
 * @author: huige
 * @date: 2022/11/18 9:51
 */
public class TestSense {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {

            System.out.println("after");
        }finally {
            reentrantLock.unlock();
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this){
                        System.out.println("等待中");
                        this.wait();
                        System.out.println("等待中");
                    }
                    System.out.println("等待中");
                    ServerSocket socket = new ServerSocket();
                    socket.bind(new InetSocketAddress(5555));
                    socket.accept();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.interrupt();

        thread.join();
    }

}
