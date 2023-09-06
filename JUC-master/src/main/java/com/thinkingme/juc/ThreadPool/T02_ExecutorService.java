/**
 * ��ʶExecutorService,�Ķ�API�ĵ�
 * ��ʶsubmit��������չ��execute����������һ������ֵ
 */
package com.thinkingme.juc.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T02_ExecutorService  {
    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
    }
}
