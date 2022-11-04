package com.mashibing.jvm;

public class TestGC {
    public static String s = " a5s4d65a46d";
    public static void main(String[] args) {
        System.out.println(s);
        for(;;) {
            new Object();
        }
    }
}
