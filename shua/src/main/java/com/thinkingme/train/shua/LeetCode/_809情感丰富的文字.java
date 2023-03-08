package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 809. 情感丰富的文字
 * </p>
 *
 * @author: huige
 * @date: 2022/11/25 9:13
 */
public class _809情感丰富的文字 {
    public static void main(String[] args) {
        System.out.println(expressiveWords("heeellooo",new String[]{"hello", "hi", "helo"}));
    }
    public static int expressiveWords(String s, String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (expressiveWords(s,words[i])){
                res++;
            }
        }
        return res;
    }
    public static boolean expressiveWords(String s, String words) {
        int p1=0,p2=0;
        while (p1<s.length() && p2<words.length() && s.charAt(p1)==words.charAt(p2)){
            int cnt1=0,cnt2=0;
            char c = s.charAt(p1);
            while (p1<s.length() && s.charAt(p1) == c){
                cnt1++;
                p1++;
            }
            while (p2<words.length() &&words.charAt(p2) == c){
                cnt2++;
                p2++;
            }
            if(cnt1<cnt2){
                return false;
            }
            if (cnt1 > cnt2 && cnt1 < 3) {
                return false;
            }
        }
        return p1==s.length() &&p2==words.length();
    }
}
