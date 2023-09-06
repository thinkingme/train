package com.thinkingme.train.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ProjectName: 题目代码
 * @Package: test
 * @ClassName: AnnotationTest
 * @Author: huige
 * @Description: 注解继承测试
 * @Date: 2021/9/3 15:09
 * @Version: 1.0
 */



public class AnnotationTest {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface C {

    }

    @Inherited
    @Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface C2 {

    }

    @Inherited
    @Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface C3{

    }

    @C
    @C2
    public interface Base {

    }

    @C
    @C3
    public class Base2 {

    }
    //@Inherited  //可以被继承
    @Retention(java.lang.annotation.RetentionPolicy.RUNTIME)   //可以通过反射读取注解
    public @interface MyAnnotation {
        String value();
    }

    @MyAnnotation(value = "接口上的注解")
    public interface ParentInf {

        @MyAnnotation(value = "接口的abstractMethod方法")
        void abstractMethod();
    }

    public class Sub implements ParentInf {
        //子类实现父类的抽象方法
        @Override
        public void abstractMethod() {
            System.out.println("子类实现接口的abstractMethod抽象方法");
        }
        public int methof(){
            return 1;
        }
    }

    public class SubImpl implements ParentInf {

        //子类实现父类的抽象方法
        @Override
        public void abstractMethod() {
            System.out.println("子类实现接口的abstractMethod抽象方法");
        }
    }

    public static void main(String[] args) throws Exception {

        Class<SubImpl> clazz = SubImpl.class;
        Annotation[] annotations3 = clazz.getAnnotations();
        System.out.println("子类 Sub 上的注解为：" + Arrays.toString(annotations3));
        Class[] i = clazz.getInterfaces();
        for (Class clz : i) {
            if(clz.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation w = (MyAnnotation)clz.getAnnotation(MyAnnotation.class);
                System.out.println("value:" + w.value());
            }

            Method[] methods = clz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    MyAnnotation w = method.getAnnotation(MyAnnotation.class);
                    System.out.println("value:" + w.value());
                }
            }
        }
    }
//    public static void main(String[] args) throws Exception {
//
//        Class<Sub> clazz = Sub.class;
//        Annotation[] annotations3 = clazz.getAnnotations();
//        System.out.println("子类 Sub 上的注解为：" + Arrays.toString(annotations3));
//    }
}
