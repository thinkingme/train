package com.thinkingme.jvm.c2_classloader;

public class T011_ClassReloading1 {
    public static void main(String[] args) throws Exception {
        T006_MSBClassLoader msbClassLoader = new T006_MSBClassLoader();
        Class clazz = msbClassLoader.loadClass("com.thinkingme.jvm.Hello");

        msbClassLoader = null;
        System.out.println(clazz.hashCode());

        msbClassLoader = null;

        msbClassLoader = new T006_MSBClassLoader();
        Class clazz1 = msbClassLoader.loadClass("com.thinkingme.jvm.Hello");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
