package com.thinkingme.jvm;

public class StackOverFlow {
    public static void main(String[] args) {
        m();
    }

    static void m() {
        m();
    }
}
