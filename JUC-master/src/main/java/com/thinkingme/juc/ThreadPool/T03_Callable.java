/**
 * ��ʶCallable����Runnable��������չ
 * ��Callable�ĵ��ã������з���ֵ
 */
package com.thinkingme.juc.ThreadPool;

import java.util.concurrent.*;

public class T03_Callable {
    public static void main(String[] args) throws Exception {
        Callable<String> c = new Callable() {
            @Override
            public String call() throws Exception {
                return "Hello Callable";
            }
        };
        String call = c.call();
        System.out.println(call);

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c); //�첽

        System.out.println(future.get());//����

        service.shutdown();
    }

}
