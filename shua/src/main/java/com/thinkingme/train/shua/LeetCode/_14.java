package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _14
 * @Author: huige
 * @Description: 最长公共前缀
 * @Date: 2021/7/26 9:24
 * @Version: 1.0
 */
public class _14 {
    public static void main(String[] args) {
        String []strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String res = "";
        int min = Math.min(strs[0].length(),strs[1].length());
        int i = 0;
        for(i = 0;i<min;i++){
            if(strs[0].charAt(i) == strs[1].charAt(i)){
            }else{
                break;
            }
        }
        res = strs[0].substring(0,i);
        if(strs.length>=3){
            for(int x = 2;x<strs.length;x++){
                min = Math.min(res.length(),strs[x].length());
                int j = 0;
                for(j = 0; j < min ; j++){
                    if(res.charAt(j) == strs[x].charAt(j)){
                    }else{
                        break;
                    }
                }
                res = res.substring(0,j);
            }

        }
        return res.toString();
    }
}
