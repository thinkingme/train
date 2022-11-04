package cn.thinkingme.train.shua.LeetCode;

public class _9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
    }
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = x + "";
        char c[] = s.toCharArray();
        int i = 0,j = c.length-1;
        for(;i<j;i++,j--){
            if(c[i] == c[j]){
                continue;
            }else{
                break;
            }
        }
        return  i>=j?true:false;
    }

}
