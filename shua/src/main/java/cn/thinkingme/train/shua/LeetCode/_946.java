package cn.thinkingme.train.shua.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * 946. 验证栈序列
 * </p>
 *
 * @author: huige
 * @date: 2022/8/31 8:55
 */
public class _946 {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{0},new int[]{0}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0; //索引popped
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
