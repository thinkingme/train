package com.thinkingme.jvm;

/**
 * <p>
 * DCL单例模式
 * </p>
 *
 * @author: huige
 * @date: 2022/5/10 10:27
 */
public class DCLSingleton {
    private volatile static DCLSingleton instance;
    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        DCLSingleton.getInstance();
    }
}
