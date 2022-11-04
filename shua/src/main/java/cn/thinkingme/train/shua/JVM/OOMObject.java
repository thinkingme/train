package cn.thinkingme.train.shua.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: JVM
 * @ClassName: OOMObject
 * @Author: huige
 * @Description: OOM演示
 * @Date: 2021/7/29 16:51
 * @Version: 1.0
 */
public class OOMObject{
    static class OOMobject {
        public byte[] placeholder = new byte[64 * 1024];
    }
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMobject> list = new ArrayList<OOMobject>();
        for (int i = 0; i < num; i++) {
//稍作延时，令监视曲线的变化更加明显Thread.sleep (50);
            list.add(new OOMobject());
        }
        System.gc();
    }
//    public static void main(String[] args) throws Exception{
//        fillHeap(1000);
//    }
    static class SynAddRunalbe implements Runnable {
        int a, b;
        public SynAddRunalbe (int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public void run( ) {
            synchronized ( Integer.valueOf (a) ){
                synchronized( Integer.valueOf(b)){
                    System.out.println (a + b);
                }
            }
        }
    }
    public static void main (String [] args){
        for (int i = 0; i <100; i++){
            new Thread (new SynAddRunalbe (1,2) ).start () ;
            new Thread (new SynAddRunalbe(2,1) ) .start ();
        }
    }

}
