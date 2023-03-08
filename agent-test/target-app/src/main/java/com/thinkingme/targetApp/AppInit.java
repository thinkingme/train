package com.thinkingme.targetApp;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2023/3/8 20:52
 */
public class AppInit {
    public static void init() {
        try {
            System.out.println("APP初始化中...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
