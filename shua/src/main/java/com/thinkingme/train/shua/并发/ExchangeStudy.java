package com.thinkingme.train.shua.并发;

import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.LockSupport;

/**
 * @ProjectName: 题目代码
 * @Package: 并发
 * @ClassName: ExchangeStudy
 * @Author: huige
 * @Description: exchange
 * @Date: 2021/10/19 13:50
 * @Version: 1.0
 */
public class ExchangeStudy {

    static Exchanger <String>exchanger = new Exchanger<>();

    public static void main(String[] args) {
        LockSupport.park();
            
    }
}
