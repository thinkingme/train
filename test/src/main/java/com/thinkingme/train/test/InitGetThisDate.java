package com.thinkingme.train.test;

import java.lang.annotation.*;

/**
 * 作用在字段上 用于给该字段自动获取当前时间 需要搭配GetTimeConf一起使用
 *
 * @author xiech
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface InitGetThisDate {

    /**
     * 默认获取时间的格式 默认yyyy-MM-dd HH:mm:ss
     * 目前支持日期的类型有 String Data LocalDateTime
     * 设置为Data需要数据库存储的数据格式或前端传送的数据为Data格式
     * String可支持设置格式
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    String thisDate() default "yyyy-MM-dd HH:mm:ss";

    /**
     * 是否需要获取时间 默认true
     *
     * @return true
     */
    boolean getTime() default true;

    /**
     * 有值的情况下是否需要重新获取时间
     *
     * @return false
     */
    boolean newGetTime() default false;

    /**
     * 用作的业务场景的方式为什么添加修改等 暂无实际意义
     *
     * @return ndf
     */
    String method() default "";
}
