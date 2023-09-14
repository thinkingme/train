package com.thinkingme.train.mian.lian;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2023/9/6 20:04
 */
import java.util.*;

public class LovelyString {

    public static TreeSet<String> result = new TreeSet<>();


    public static void main(String[] args) {
        int n = 5;
        Set<String> strings = generateRedStrings(n);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static Set<String> generateRedStrings(int n) {
        Set<String> result = new HashSet<>();
        generateRedStringsHelper("", 0, n, result);
        return result;
    }

    private static void generateRedStringsHelper(String current, int index, int n, Set<String> result) {
        if (index == n) {
            if (hasSubsequence(current) && !current.contains("red")) {
                result.add(current);
            }
            return;
        }

        generateRedStringsHelper(current + "r", index + 1, n, result);
        generateRedStringsHelper(current + "e", index + 1, n, result);
        generateRedStringsHelper(current + "d", index + 1, n, result);
    }
    // 使用indexOf方法判断
    public static boolean hasSubsequence(String s) {
        // 先找到'r'的位置
        int rIndex = s.indexOf('r');
        // 如果没有找到'r'，返回false
        if (rIndex == -1) {
            return false;
        }
        // 从'r'之后开始找'e'的位置
        int eIndex = s.indexOf('e', rIndex + 1);
        // 如果没有找到'e'，返回false
        if (eIndex == -1) {
            return false;
        }
        // 从'e'之后开始找'd'的位置
        int dIndex = s.indexOf('d', eIndex + 1);
        // 如果没有找到'd'，返回false
        if (dIndex == -1) {
            return false;
        }
        // 如果都找到了'r'、'e'和'd'，返回true
        return true;
    }
}

