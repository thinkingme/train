package com.mashibing.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Locale;

/**
 * <p>
 * 测试动态代理
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/4/14 16:18
 */
public class TestInfect {
    public static void main(String[] args) {
        //得是接口类，不然报错
        IHello hello = (IHello)new DynaProxyHello().bind(new TestHello());
        hello.sayGoogBye("Double J");
        hello.sayHello("Double J");
    }

}
interface IHello {
    /**
     * 业务处理A方法
     * @param name
     */
    void sayHello(String name);
    /**
     * 业务处理B方法
     * @param name
     */
    void sayGoogBye(String name);
}
class TestHello implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
    @Override
    public void sayGoogBye(String name) {
        System.out.println(name+" GoodBye!");
    }
}
class DynaProxyHello implements InvocationHandler {
    /**
     * 要处理的对象(也就是我们要在方法的前后加上业务逻辑的对象,如例子中的Hello)
     */
    private Object delegate;
    /**
     * 动态生成方法被处理过后的对象 (写法固定)
     *
     * @param delegate
     * @param proxy
     * @return
     */
    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
    }
    /**
     * 要处理的对象中的每个方法会被此方法送去JVM调用,也就是说,要处理的对象的方法只能通过此方法调用
     * 此方法是动态的,不是手动调用的
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            //执行原来的方法之前记录日志


            //JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
            //执行原来的方法之后记录日志

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回方法返回值给调用者
        return result;
    }
}