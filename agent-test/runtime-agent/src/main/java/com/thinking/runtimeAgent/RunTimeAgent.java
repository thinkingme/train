package com.thinking.runtimeAgent;

import java.lang.instrument.Instrumentation;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2023/3/8 20:36
 */
public class RunTimeAgent {

    public static void premain(String arg, Instrumentation instrumentation) {
        System.out.println("探针启动！！！");
        System.out.println("探针传入参数：" + arg);
        instrumentation.addTransformer(new RunTimeTransformer());
    }
}