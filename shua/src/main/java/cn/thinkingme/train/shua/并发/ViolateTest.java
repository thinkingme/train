package cn.thinkingme.train.shua.并发;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/2/9 22:36
 */
public class ViolateTest {

    public static void main(String[] args) throws Exception {
        ArrayList arrayList = new ArrayList();
        Object o = new Object();

        new Thread(() -> {
            //线程B
            while (true) {
                if (arrayList.size() == 500) {
                    System.out.println("结束");
                    break;
                }
            }
        }).start();
        new Thread(() -> {
            //线程B
            while (true) {
                if (arrayList.size() == 500) {
                    System.out.println("结束");
                    break;
                }
            }
        }).start();
        new Thread(() -> {
            //线程B
            while (true) {
                if (arrayList.size() == 500) {
                    System.out.println("结束");
                    break;
                }
            }
        }).start();
        new Thread(() -> {
            //线程A
//            try {
//                TimeUnit.MILLISECONDS.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int i = 0; i < 1000; i++) {
                arrayList.add(new Object());
                System.out.println(i+1);
            }
        }).start();
        try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(arrayList.size());

    }
}
