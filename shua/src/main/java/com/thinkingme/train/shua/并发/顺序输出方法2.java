package com.thinkingme.train.shua.并发;

import java.util.concurrent.CountDownLatch;

public class 顺序输出方法2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Foo foo = new Foo();
                StringBuilder sb = new StringBuilder();

                CountDownLatch latch = new CountDownLatch(3);
                new Thread(() -> {
                    try {
                        foo.third(() -> sb.append("third"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }).start();
                new Thread(() -> {
                    try {
                        foo.first(() -> sb.append("first"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }).start();
                new Thread(() -> {
                    try {
                        foo.four(() -> sb.append("four"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }).start();

                // 最后输出结果
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(sb.toString());
            }).start();
        }
    }
}
class Foo {
    private static volatile int flag = 1;
    private static final Object object = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) object.wait();
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public void third(Runnable printthird) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) object.wait();
            printthird.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void four(Runnable printfour) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) object.wait();
            printfour.run();
            flag = 1;
            object.notifyAll();
        }

    }
}