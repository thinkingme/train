package com.thinkingme.train.test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * 搭配接口{@InitGetThisDate}一起使用 用于给某个字段获取当前时间
 *
 * @author xiech
 */

public final class InitDate {
    private static final String A = "java.util.Date";
    private static final String B = "java.lang.String";
    private static final String C = "java.time.LocalDateTime";

    public static <T extends GetTimeConf> T initDate(T t) {
        Class<? extends Object> cls = t.getClass();
        Field[] fields = cls.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> {
            if (f.isAnnotationPresent(InitGetThisDate.class)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f.getAnnotation(InitGetThisDate.class).thisDate());
                if (f.getAnnotation(InitGetThisDate.class).getTime()) {
                    if (f.getAnnotation(InitGetThisDate.class).newGetTime()) {
                        f.setAccessible(true);
                        try {
                            if (A.equals(f.getType().getName())) {
                                f.set(t, new Date());
                            } else if (B.equals(f.getType().getName())) {
                                f.set(t, simpleDateFormat.format(new Date()));
                            } else if (C.equals(f.getType().getName())) {
                                f.set(t, LocalDateTime.now());
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Object o = f.get(t);
                            if (o == null) {
                                if (A.equals(f.getType().getName())) {
                                    f.set(t, new Date());
                                } else if (B.equals(f.getType().getName())) {
                                    f.set(t, simpleDateFormat.format(new Date()));
                                } else if (C.equals(f.getType().getName())) {
                                    f.set(t, LocalDateTime.now());
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        return t;
    }
}
