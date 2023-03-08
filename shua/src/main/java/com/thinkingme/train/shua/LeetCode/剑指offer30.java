package com.thinkingme.train.shua.LeetCode;

import java.util.Stack;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: 剑指offer30
 * @Author: huige
 * @Description: 包含min函数的栈
 * @Date: 2021/11/10 15:52
 * @Version: 1.0
 */
public class 剑指offer30 {
    class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> stack;
        int min = Integer.MAX_VALUE;

        public MinStack() {
            stack  = new Stack<Integer>();
        }

        public void push(int x) {
            stack.push(x);
            min = Math.min(x, stack.peek());
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }

    public static void main(String[] args) {

    }
}
