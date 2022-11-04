package cn.thinkingme.train.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ProjectName: 题目代码
 * @Package: test
 * @ClassName: A
 * @Author: huige
 * @Description: 11
 * @Date: 2021/10/14 17:04
 * @Version: 1.0
 */
public class A extends GetTimeConf<A>{
      public A() {
          this.init(this);
      }
      static int ss = 1;
      @InitGetThisDate
      public LocalDateTime data;

      public static void fun(){

      }

    public static<T> void main(String[] args) {
        System.out.println(ss);
        A a = new A();
        List<String> list = Arrays.asList("   a1", "a2", "b1", "c1", "c2");
        list.stream()
                .filter(s->{
                    ss++;return s.startsWith("c");}
                )
                .map(String::toUpperCase)
                .sorted().collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println(ss);

        Consumer<? super String > greeter = (p) -> System.out.println("Hello, " + p);
        greeter.accept("Skywalker");

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        // "123"
        backToString.apply("123");
    }
}
