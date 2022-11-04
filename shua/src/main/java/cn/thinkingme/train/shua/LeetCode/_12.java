package cn.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _12
 * @Author: huige
 * @Description: 整数转罗马数字
 * @Date: 2021/7/23 16:21
 * @Version: 1.0
 */
public class _12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }
    public static String intToRoman(int num) {
        String [][]rules = {
                {"I","V","X"},
                {"X","L","C"},
                {"C","D","M"},
                {"M"}
        };
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<4;i++){
            int n = num%10;
            if(n == 4 ){
                stringBuffer.insert(0,rules[i][1]).insert(0,rules[i][0]);
            }else if( n == 9){
                stringBuffer.insert(0,rules[i][2]).insert(0,rules[i][0]);
            }else if(n<4){
                while(n-->0){
                    stringBuffer.insert(0,rules[i][0]);
                }
            }else if(n>=5){
                while(n-- > 5){
                    stringBuffer.insert(0,rules[i][0]);
                }
                stringBuffer.insert(0,rules[i][1]);
            }
            num/=10;
        }
        return stringBuffer.toString();
    }
}
