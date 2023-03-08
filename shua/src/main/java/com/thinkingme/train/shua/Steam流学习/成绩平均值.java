package com.thinkingme.train.shua.Steam流学习;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: 题目代码
 * @Package: Steam流学习
 * @ClassName: 成绩平均值
 * @Author: huige
 * @Description:
 * @Date: 2021/9/10 16:07
 * @Version: 1.0
 */
class chengji{
    String name;
    double score;

    public chengji(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public chengji() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

public class 成绩平均值 {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("1,小红,95","2,小白,99","3,小狼,88","4,小绿,1","5,小白,100","5,小白,100","1,小红,78","2,小红,99","3,小红,88","4,小绿,55","5,小白,100","5,小白,100");
        List<chengji> collect = str.stream().map(s -> {
            String[] split = s.split(",");
            return new chengji(split[1], Double.parseDouble(split[2]));
        }).collect(Collectors.toList());

        Map<String, Double> sortedTreeMapComparator = collect.stream().collect(Collectors.groupingBy(chengji::getName, () -> new LinkedHashMap<>(), Collectors.averagingDouble((item -> item.getScore()))));
        //map排序
        Random random = new Random();
        sortedTreeMapComparator.entrySet().stream()
                .sorted(Map.Entry
                        .comparingByValue())
                .forEach(System.out::println);

    }
}
