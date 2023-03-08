package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 * 385. 迷你语法分析器
 * </p>
 *
 * @author: huige
 * @date: 2022/4/15 14:49
 */
public class _385迷你语法分析器 {
    static NestedInteger ph = new NestedInteger(0);

    /**
     * 栈
     * @param s
     * @return
     */
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> d = new ArrayDeque<>();

        char[] cs = s.toCharArray();
        int n = cs.length, i = 0;
        while (i < n) {
            if (cs[i] == ',' && ++i >= 0) continue;
            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
                int j = cs[i] == '-' ? i + 1 : i, num = 0;
                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) num = num * 10 + (cs[j++] - '0');
                d.addLast(new NestedInteger(cs[i] == '-' ? -num : num));
                i = j;
            }else if (cs[i] == '[') {
                d.addLast(new NestedInteger());
                d.addLast(ph);
                i++;
            } else {
                List<NestedInteger> list = new ArrayList<>();
                while (!d.isEmpty()) {
                    NestedInteger poll = d.pollLast();
                    if (poll == ph) break;
                    list.add(poll);
                }
                for (int j = list.size() - 1; j >= 0; j--) d.peekLast().add(list.get(j));
                i++;
            }
        }
        return d.peekLast();
    }

    /**
     * 递归
     */
    class Solution {
        int index = 0;

        public NestedInteger deserialize(String s) {
            if (s.charAt(index) == '[') {
                index++;
                NestedInteger ni = new NestedInteger();
                while (s.charAt(index) != ']') {
                    ni.add(deserialize(s));
                    if (s.charAt(index) == ',') {
                        index++;
                    }
                }
                index++;
                return ni;
            } else {
                boolean negative = false;
                if (s.charAt(index) == '-') {
                    negative = true;
                    index++;
                }
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                if (negative) {
                    num *= -1;
                }
                return new NestedInteger(num);
            }
        }
    }

}

class NestedInteger  {
    public NestedInteger() {

    }

    public NestedInteger(int value){

    }

    public boolean isInteger() {
        return false;
    }

    public Integer getInteger() {
        return null;
    }

    public void setInteger(int value) {

    }

    public void add(NestedInteger ni) {

    }

    public List<NestedInteger> getList() {
        return null;
    }
}