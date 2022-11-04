package cn.thinkingme.train.shua.并发;

import java.util.concurrent.CountDownLatch;

public class Leecode1115 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                FooBar foo = new FooBar(5);
                StringBuilder sb = new StringBuilder();

                CountDownLatch latch = new CountDownLatch(2);
                new Thread(() -> {
                    try {
                        foo.foo(() -> sb.append("foo"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }).start();
                new Thread(() -> {
                    try {
                        foo.bar(() -> sb.append("bar"));
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
class FooBar {
    private volatile int flag = 1;
    private final Object object = new Object();
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (object) {
                while (flag != 1) object.wait();
                printFoo.run();
                flag = 2;
                object.notifyAll();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (object) {
                while (flag != 2) object.wait();
                printBar.run();
                flag = 1;
                object.notifyAll();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.

        }
    }
}