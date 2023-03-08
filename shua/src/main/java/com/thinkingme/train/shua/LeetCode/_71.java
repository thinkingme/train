package com.thinkingme.train.shua.LeetCode;

import java.util.Stack;

/**
 * @Author: huige
 * @Description: 71. 简化路径
 * @Date: 2022/1/6 11:14
 */
public class _71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack <String>stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if("..".equals(split[i]) && !stack.isEmpty()){
                stack.pop();
            }else if(split[i].length()>0 && !".".equals(split[i]) && !"..".equals(split[i])){
                stack.push(split[i]);
            }
        }
        return "/" + String.join("/", stack);
    }
}
