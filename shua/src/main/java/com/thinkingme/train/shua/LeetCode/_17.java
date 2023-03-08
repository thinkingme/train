package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _17
 * @Author: huige
 * @Description: 电话号码的字母组合
 * @Date: 2021/7/26 16:21
 * @Version: 1.0
 */
public class _17 {
    public static Stack<Character> s = new Stack<>();

    public static void main(String[] args) {
        System.out.println(letterCombinations("789"));
    }
    public static List<String> letterCombinations(String digits) {
        Character [][]rules = {
                {' ',' ',' '},
                {' ',' ',' '},
                {'a', 'b', 'c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        ArrayList<String> arrayList = new ArrayList<>();
        dfs(rules,digits,0,arrayList);
        return arrayList;
    }
    public static void dfs(Character [][]rules , String digits, int cur, ArrayList<String> arrayList){
        if(cur == digits.length()){
            StringBuilder sb = new StringBuilder();
            Iterator<Character> it = s.iterator();
            while(it.hasNext()){
                sb.append(it.next());
            }
            arrayList.add(sb.toString());
            return;
        }
        int temp = Integer.parseInt(digits.charAt(cur)+"");
        for(int i =0;i<rules[temp].length;i++){
            s.add(rules[temp][i]);
            dfs(rules,digits,cur+1,arrayList);
            s.pop();
        }
    }

}
