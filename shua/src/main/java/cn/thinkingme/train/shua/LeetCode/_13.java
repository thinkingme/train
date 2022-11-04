package cn.thinkingme.train.shua.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _13
 * @Author: huige
 * @Description: 罗马数字转整数
 * @Date: 2021/7/26 8:44
 * @Version: 1.0
 */
public class _13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));

    }


    public static int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
