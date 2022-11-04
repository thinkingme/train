package cn.thinkingme.train.test;

import java.io.Serializable;

/**
 * 用于配置类的字段 继承至mybatis的Model可实现单表crud
 * 使用方法只需要将类继承GetTimeConf 并且将构造函数调用init即可
 * 比如即可将该字段自动配置当前时间
 *  public class A extends GetTimeConf<A>{
 *     public () {
 *         this.init(this);
 *     }
 *     @InitGetThisDate
 *     public String data;
 *  }
 * @param <T>
 * @author xiech
 */

public class GetTimeConf<T extends GetTimeConf<?>> implements Serializable {
    public void init(T t) {
        InitDate.initDate(t);
    }
}
