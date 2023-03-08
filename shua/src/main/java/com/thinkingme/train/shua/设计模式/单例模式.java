package com.thinkingme.train.shua.设计模式;

//public class 单例模式 {
//  // 创建一个实例对象
//    private static 单例模式 instance = new 单例模式();
//    /**
//     * 私有构造方法，防止被实例化
//     */
//    private 单例模式(){}
//    /**
//     * 静态get方法
//     */
//    public static 单例模式 getInstance(){
//        return instance;
//    }
//}
/*
 * 内部类建立单例
 */
public class 单例模式 {  
	  
    /* 私有构造方法，防止被实例化 */  
    private 单例模式() {  
    }  
  
    /* 此处使用一个内部类来维护单例 */  
    private static class SingletonFactory {  
        private static 单例模式 instance = new 单例模式();  
    }  
  
    /* 获取实例 */  
    public static 单例模式 getInstance() {  
        return SingletonFactory.instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return getInstance();  
    } 
    public static void main(String[] args) {
		单例模式 d单例模式 = new 单例模式();
		System.out.println(d单例模式 == 单例模式.getInstance());
	}
}  
//public enumTest Singleton {
//    /**
//     * 定义一个枚举的元素，它就代表了Singleton的一个实例。
//     */
//    Instance;
//}