package com.thinkingme.targetApp;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

/**
 * <p>
 * 目标应用
 * </p>
 *
 * @author: huige
 * @date: 2023/3/8 20:33
 */
public class APPMain {

    public static void main(String[] args) {
        System.out.println("APP 启动！！！");
        AppInit.init();
    }


    //attach 方式调用
//    public static void main(String[] args) {
//        System.out.println("APP 启动！！！");
//        for (VirtualMachineDescriptor vmd : VirtualMachine.list()) {
//            // 指定的VM才可以被代理
//            if (true) {
//                System.out.println("该VM为指定代理的VM");
//                System.out.println(vmd.displayName());
//                try {
//                    VirtualMachine vm = VirtualMachine.attach(vmd.id());
//                    vm.loadAgent("D:/Code/java/idea_project/agent-test/runtime-agent/target/runtime-agent-1.0-SNAPSHOT.jar=hello");
//                    vm.detach();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        AppInit.init();
//    }

}