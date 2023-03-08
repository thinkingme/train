package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _171
 * @Author: huige
 * @Description: Excel 表列序号
 * @Date: 2021/7/30 15:27
 * @Version: 1.0
 */
public class _171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }
    public static int titleToNumber(String columnTitle) {
        /**
            1000 =
         */
        int len = columnTitle.length()-1;
        int res = 0;
        for(int i = 0;i<columnTitle.length();i++){
            res = res + (columnTitle.charAt(i)-'A'+1) * (int)Math.pow(26,len--);
        }
        return res;
    }
}
