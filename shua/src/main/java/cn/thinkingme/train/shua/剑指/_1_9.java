package cn.thinkingme.train.shua.剑指;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <p>
 * 剑指 Offer 09. 用两个栈实现队列
 * </p>
 *
 * @author: huige
 * @date: 2022/8/30 11:13
 */
public class _1_9 {



    class CQueue {
        Deque<Integer> left = new ArrayDeque<Integer>();
        Deque<Integer> right = new ArrayDeque<Integer>();
        public CQueue() {

        }

        public void appendTail(int value) {
            left.push(value);
        }

        public int deleteHead() {
            if(!right.isEmpty()){
                return right.pop();
            }
            while(!left.isEmpty()){
                right.push(left.pop());
            }
            if (right.peek()!=null){
                return right.pop();
            }else{
                return -1;
            }
        }
    }
}
