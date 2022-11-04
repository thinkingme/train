package com.mashibing.jvm;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *直接内存测试
 * 设置JVM参数-Xmx100m，运行异常，因为如果没设置-XX:MaxDirectMemorySize，则默认与-Xmx参数值相同，分配128M直接内存超出限制范围。
 * </p>
 *
 * @author: huige
 * @date: 2022/4/21 14:42
 */
public class DirectMemoryTest {
    public static int a = 0;
    static{
        System.out.println("DirectMemoryTest init");
    }
    {
        System.out.println("DirectMemoryTest init2");
    }
    public DirectMemoryTest(){
        System.out.println("DirectMemoryTest init3");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(DirectMemoryTest.a);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 128);
        ByteBuffer bb = ByteBuffer.allocateDirect(1024 * 1024 * 128);
        ByteBuffer bb2 = ByteBuffer.allocateDirect(1024 * 1024 * 128);
        System.out.println(byteBuffer.isDirect());
        TimeUnit.SECONDS.sleep(10);
    }
}
