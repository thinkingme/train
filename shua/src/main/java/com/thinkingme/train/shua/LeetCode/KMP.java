package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: KMP
 * @Author: huige
 * @Description: KMP算法
 * @Date: 2021/8/19 13:13
 * @Version: 1.0
 */
public class KMP {
    public static void main(String[] args) {
        System.out.println(strStr("abcabcabfd","abcabf"));
    }
    public static int strStr(String haystack, String needle) {
        // KMP算法：如果已经匹配的字符串包含相同的前缀和后缀，遇到下一个不匹配的位置时，指向needle的指针跳转到前缀的后一个位置，还是不匹配的话，再往前跳转后继续比较；先构造一个next数组来记录needle指针跳转的位置
        int n=haystack.length(), m=needle.length();
        if(m==0) return 0;
        // 先构造next数组，next数组中的元素表示当前两个元素不匹配时，needle指针要跳转的位置
        // haystack: [a, b, c, a, b, c, a, b, f, d]
        // needle:   [a, b, c, a, b, f]
        // next:     [0, 0, 0, 1, 2, 0]
        int[] next = new int[m];
        for(int i=1,j=0; i<m; i++){
            while(j>0 && needle.charAt(i)!=needle.charAt(j))
                j = next[j-1]; // 一直和前一位置的值比较，直到遇到相等的字符或者j=0；j通过next[j-1]来回退
            if(needle.charAt(i)==needle.charAt(j)) j++;
            next[i] = j;
        }
        // 利用next数组进行跳转匹配，不再需要回退haystack的指针i
        for(int i=0,j=0; i<n; i++){
            // 匹配不成功，needle指针j回退并继续比较
            while(j>0 && haystack.charAt(i)!=needle.charAt(j))
                j = next[j-1];
            if(haystack.charAt(i)==needle.charAt(j)) j++;
            if(j==m) return i - m + 1;
        }
        return -1;
    }
}
