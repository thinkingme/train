package com.thinkingme.train.test;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/1/24 10:47
 */
public class Final测试 {
    private volatile String string = "45465";

    /**
     * final表示类指针指向的地址不能变化，也就是不能赋值别的对象值，单例
     * Java 内存模型 (JMM) 保证任何可以看到对最终对象的引用的线程都将看到该对象的最终状态，即使该对象不是通过内存屏障发布的。 这意味着使用 final 关键字可以帮助确保其他线程看到对象的一致视图。
     */
    private final static Final测试 final测试 = new Final测试();

    public Final测试() {

    }

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        final测试.string = "4564";
        System.out.println(final测试.string);
    }
}
