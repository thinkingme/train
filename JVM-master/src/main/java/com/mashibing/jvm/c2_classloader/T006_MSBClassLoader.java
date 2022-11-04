package com.mashibing.jvm.c2_classloader;

import com.mashibing.jvm.Hello;

import java.io.*;

public class T006_MSBClassLoader extends ClassLoader {

    public static int a = 545;

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        File file = new File("D:/workspace/IDEAworkspace/JVM-master/out/production/JVM/"+name.replace(".","/").concat(".class"));
        if (!file.exists()){
            return super.loadClass(name);
        }
        try {
            InputStream is = new FileInputStream(file);
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name,b,0,b.length);
        }catch (IOException e){
            e.printStackTrace();
        }
        return super.loadClass(name);
    }

//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        File f = new File("D:\\workspace\\IDEAworkspace\\JVM-master\\out\\production\\JVM\\com\\mashibing\\jvm\\c2_classloader\\T006_MSBClassLoader.class");
//        try {
//            FileInputStream fis = new FileInputStream(f);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            int b = 0;
//
//            while ((b=fis.read()) !=0) {
//                baos.write(b);
//            }
//
//            byte[] bytes = baos.toByteArray();
//            baos.close();
//            fis.close();//可以写的更加严谨
//
//            return defineClass(name, bytes, 0, bytes.length);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return super.findClass(name); //throws ClassNotFoundException
//    }

    public static void main(String[] args) throws Exception {
        int a;
        ClassLoader l = new T006_MSBClassLoader();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(com.mashibing.jvm.c2_classloader.T006_MSBClassLoader.class.getClassLoader());
        Class clazz = l.loadClass("com.mashibing.jvm.c2_classloader.T006_MSBClassLoader");

        System.out.println(clazz.getClassLoader());

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());

        System.out.println(getSystemClassLoader());
    }
}
