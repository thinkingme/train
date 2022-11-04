/**
 * 问题的原因与普通的双重检查锁定单例模式(Double Checked Locking,DCL)10类似，即SomeThing的构建与将指向构建中的SomeThing引用赋值到object变量这两者可能会发生重排序。导致get中返回一个正被构建中的不完整的SomeThing对象实例。
 *
 * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 * 也可以利用 unsafe.putOrderedObject来手动加入屏障，保证不会发生指令重排序
 * 相关链接 https://tech.meituan.com/2014/09/23/java-memory-reordering.html
 */
package com.mashibing.juc.c_012_Volatile;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class T03________VolatileReference2 {

    private static final Unsafe unsafe = getUnsafe();

    private static class Data {
        int a, b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    private static final long valueOffset;
    static {
        try {
            valueOffset = unsafe.objectFieldOffset(T03________VolatileReference2.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private Object value;
    volatile static Data data;

    public static void main(String[] args) {
        final T03________VolatileReference2 some = new T03________VolatileReference2();

        Thread writer = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                data = some.createData(i);
            }
        });
        Thread reader = new Thread(()->{
            while (T03________VolatileReference2.data == null) {
                Thread.yield();
            }
            int x = T03________VolatileReference2.data.a;
            int y = T03________VolatileReference2.data.b;
            if(x != y) {
                System.out.printf("a = %s, b=%s%n", x, y);
            }
        });

        reader.start();
        writer.start();

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe)f.get(null);
        } catch (Exception e) {
        }
        return null;
    }

    public Data createData(int i) {
        Data temp = new Data(i,i);
        unsafe.putOrderedObject(this, valueOffset, null);	//将value赋null值只是一项无用操作，实际利用的是这条语句的内存屏障
        return temp;
    }
}
