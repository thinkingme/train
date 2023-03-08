package com.thinkingme.jvm.c3_jmm;

/**
 * 指令重排序验证
 * 在单线程程序中，对存在控制依赖的操作重排序，不会改变执行结果（这也是as-if-serial语义允许对存在控制依赖的操作做重排序的原因）；
 * 但在多线程程序中，对存在控制依赖的操作重排序，可能会改变程序的执行结果。
 *
 */
public class T04_Disorder {
    //加入volatile也没用，因为保证对象里面属性的可见性，和重排序
    private volatile static A ao = new A();
    private volatile static B bo = new B();

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for(;;) {
            i++;
            bo.x = 0; bo.y = 0;
            ao.a = 0; ao.b = 0;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    //由于线程one先启动，下面这句话让它等一等线程two. 读着可根据自己电脑的实际性能适当调整等待时间.
                    //shortWait(100000);
                    ao.a = 1;
                    bo.x = ao.b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    ao.b = 1;
                    bo.y = ao.a;
                }
            });
            one.start();other.start();
            one.join();other.join();
            String result = "第" + i + "次 (" + bo.x + "," + bo.y + "）";
            if(bo.x == 0 && bo.y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }


    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}
class A{
    int a = 0;
    int b = 0;
}
class B{
    int x = 0;
    int y = 0;
}