package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _38
 * @Author: huige
 * @Description: 外观数列
 * @Date: 2021/9/7 14:52
 * @Version: 1.0
 */
public class _38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
    public static String countAndSay(int n) {
        String origin = "1";
        for(int i = 0;i<n-1;i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int j = 1;
            for(;j<origin.length();j++){
                if(origin.charAt(j)==origin.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count+""+origin.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count+""+origin.charAt(j-1));
            origin = sb.toString();
        }
        return origin;
    }
}
