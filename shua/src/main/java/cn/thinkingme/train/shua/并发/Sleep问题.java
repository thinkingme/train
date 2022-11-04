package cn.thinkingme.train.shua.并发;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Sleep问题 {

    //定义一个lock锁
    private static final Lock lock = new ReentrantLock();

    static class NumberThread implements Runnable {
        @Override

        public void run() {
            synchronized (Sleep问题.class) {
            	System.out.println(Thread.currentThread().getName() + "准备睡眠");
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    
                    System.out.println(Thread.currentThread().getName() + "释放锁了");
                }
			}
            
        }
    }

    public static int count = 0;

    public static void main(String[] args) {
        new Thread(()-> {
        	synchronized (Sleep问题.class) {
        		try {
                    Thread.sleep(500);
                    System.out.println(new Date()+Thread.currentThread().getName()+","+count);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        	}
        }).start();
        new Thread(()-> {
        	synchronized (Sleep问题.class) {
		        try {
		            count = 10;
		            Thread.sleep(1000);
		            System.out.println(Thread.currentThread().getName()+","+count);
		
		        } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
        	}
        }).start();
    }
//    public static void main(String[] args) throws InterruptedException {
//        long startTime = System.currentTimeMillis();
//        NumberThread numberThread = new NumberThread();
//        Thread thread1 = new Thread(numberThread, "第一个线程");
//        Thread thread2 = new Thread(numberThread, "第二个线程");
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println("总耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");
//    }
}


