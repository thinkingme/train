package cn.thinkingme.train.shua.LeetCode;

import java.util.Stack;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _20
 * @Author: huige
 * @Description: 有效的括号
 * @Date: 2021/7/28 16:12
 * @Version: 1.0
 */
public class _20 {

    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char a[] = s.toCharArray();
        for(char c:a){
            if(c == '('||c=='{'||c=='['){
                stack.push(c);
            }else if(stack.isEmpty()){
                return false;
            }else if(c == ')' &&stack.peek() == '('){
                stack.pop();
            }else if(c == '}' &&stack.peek() == '{'){
                stack.pop();
            }else if(c == ']' &&stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
