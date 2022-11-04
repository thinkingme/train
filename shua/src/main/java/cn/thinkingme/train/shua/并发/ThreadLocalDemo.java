package cn.thinkingme.train.shua.并发;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: 题目代码
 * @Package: 并发
 * @ClassName: ThreadLocal
 * @Author: huige
 * @Description: 学习ThreadLocal
 * @Date: 2021/8/13 16:31
 * @Version: 1.0
 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        firstStack();
        Thread thread = Thread.currentThread();
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread); // 在这里打断点，观察thread对象里的ThreadLocalMap数据

    }
    // 通过是否获取返回值观察A对象里的local对象是否被回收
    private static A firstStack(){
        A a = new A();
        System.out.println("value: "+ a.get());
        return a;
    }
    private static class A{
        private ThreadLocal<String> local = ThreadLocal.withInitial(() -> "in class A");

        public String get(){
            return local.get();
        }
        public void set(String str){
            local.set(str);
        }

    }
}