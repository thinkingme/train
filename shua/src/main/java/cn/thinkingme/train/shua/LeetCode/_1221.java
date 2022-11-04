package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _1221
 * @Author: huige
 * @Description: 分割平衡字符串
 * @Date: 2021/9/7 9:07
 * @Version: 1.0
 */
public class _1221 {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }
    public static int balancedStringSplit(String s) {
        int r= 0,l = 0;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'L'){
                l++;
                if(r == l){
                    res++;
                    r = 0;
                    l = 0;
                }
            }else{
                r++;
                if(r == l){
                    res++;
                    r = 0;
                    l = 0;
                }
            }
        }
        return res;
    }
}
