package com.thinkingme.train.test;

import java.util.ArrayList;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2023/11/22 13:33
 */
public class ForEach {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);

        for (int i = 0; i < integers.size(); i++) {
            integers.remove(i);
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        final String toRemove = "2";
        final String toAdd = "1000";
        //item = "100"; //这句执行无效，仅仅改变迭代器中item的指向，并不会真正改变list中的元素
        //仅当toRemove为"3"时，没有报异常。这是删除倒数第二个元素情况下的“巧合”。
        //list.add(toAdd); // 报ConcurrentModificationException
        list.removeIf(toRemove::equals);
    }
}
