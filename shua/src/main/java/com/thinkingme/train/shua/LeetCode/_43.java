package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _43
 * @Author: huige
 * @Description: 字符串相乘
 *
 *         num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
 *         例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
 *           index:    0 1 2 3 4
 *
 *                         1 2 3
 *                     *     4 5
 *                     ---------
 *                           1 5
 *                         1 0
 *                       0 5
 *                     ---------
 *                       0 6 1 5
 *                         1 2
 *                       0 8
 *                     0 4
 *                     ---------
 *                     0 5 5 3 5
 *         这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中
 *
 * @Date: 2021/9/28 11:36
 * @Version: 1.0
 */
public class _43 {
    public static void main(String[] args) {
        System.out.println(multiply("6","8"));
    }
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length();
        int n2= num2.length();
        int []ans = new int[n1+n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int res = (num1.charAt(i)-'0') * (num2.charAt(j)-'0') + ans[i+j+1];
                ans[i+j+1] = res%10;
                ans[i+j] += res/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ans.length;i++){
            if(i==0 && ans[i]==0){
                continue;
            }
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
