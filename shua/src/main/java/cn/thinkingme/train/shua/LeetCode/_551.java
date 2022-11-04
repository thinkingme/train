package cn.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _551
 * @Author: huige
 * @Description: 学生出勤记录 I
 * @Date: 2021/8/17 17:26
 * @Version: 1.0
 */
public class _551 {
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'A'){
                count++;
                if(count>1)return false;
            }
        }
        return !s.contains("LLL");
    }
}
