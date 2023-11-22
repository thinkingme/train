package com.thinkingme.train.test.笔试;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *测试程序初始化顺序
 * </p>
 *
 * @author: huige
 * @date: 2023/10/16 18:45
 */
public class AABB {

    static String result = "";
    static void method(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        }catch(Exception e){
            result += "2";
            return;
        }finally{
            result += "3";
        }
        result += "4";
    }

    public static void main(String[] args){
        Derived de =new Derived();
        de.printAB();

        method(1);
        method(0);
        System.out.println(result);

        List<String> list = new LinkedList<>();
        list.add("t");
        list.add(2,"m");
        String s = (String) list.get(1);
        System.out.println(s);

        //测试程序初始化顺序
        B b = new B();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aa");
            }
        });
        a.start();
        a.start();

    }
}



class A{

    static String str1 = "父类A的静态变量";
    String str2 = "父类A的非静态变量";

    static {
        System.out.println("执行了父类A的静态代码块");
    }

    {
        System.out.println("执行了父类A的非静态代码块");
    }

    public A(){
        System.out.println("执行了父类A的构造方法");
    }
}

class B extends A{

    static String str1 = "子类B的静态变量";
    String str2 = "子类B的非静态变量";

    static {
        System.out.println("执行了子类B的静态代码块");
    }

    {
        System.out.println("执行了子类B的非静态代码块");
    }

    public B(){
        System.out.println("执行了子类B的构造方法");
    }
}

class Base {
    public void printA() {
        System.out.println("baseA");
    }
    private void printB() {
        System.out.println("base B");
    }
    public void printAB() {
        printA();
        printB();
    }
}
class Derived extends Base {
    @Override
    public void printA() {
        System.out.println("Derived A");
    }

    private void printB() {
        System.out.println("Derived B");
    }
}
