package cn.thinkingme.train.shua.刷题;

import java.util.*;


public class 加减乘计算器 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
       public int solve(String s)
    {

        // 请写一个整数计算器，支持加减乘三种运算和括号。
        // write code here
        //idea the () could be regarded as a computing element using the recursion method
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int sum = 0;
        char sign = '+';
        char[] c = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            char ele = c[i];
            //process the numerical situation
            if (Character.isDigit(ele))
            {
                number = number * 10 + ele - '0';
            }
            //process the () situation
            if (ele == '(')
            {
                int j = i + 1;
                int counterPar = 1;
                String subPar = "";
                //extract the most outer group and recursevely preocess
                while (counterPar > 0)
                {
                    if (c[j] == '(')
                    {
                        counterPar++;
                    }
                    if (c[j] == ')')
                    {
                        counterPar--;
                    }
                    j++;
                }
                subPar = s.substring(i + 1, j);
                number=solve(subPar);
                i = j-1;
            }
            //real work block
            if (ele != ' ' && !Character.isDigit(ele) || i == n - 1)
            {
                if (sign == '+')
                {
                    stack.push(number);
                }
                else if (sign == '-')
                {
                    stack.push(-1 * number);
                }
                else if (sign == '*')
                {
                    stack.push(stack.pop() * number);
                }
                else if (sign == '/')
                {
                    stack.push(stack.pop() / number);
                }
                //change the sign and number
                number = 0;
                sign = ele;
            }

        }
        while (!stack.isEmpty())
        {
            sum+=stack.pop();
        }
        return sum;
    }
}
