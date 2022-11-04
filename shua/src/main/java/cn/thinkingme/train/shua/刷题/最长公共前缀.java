package cn.thinkingme.train.shua.刷题;

import java.util.*;


public class 最长公共前缀 {
    public String longestCommonPrefix (String[] strs) {
        int length = strs.length;
         if(length == 0) 
            return "";
        String ans = strs[0];
        for(int i =1;i<length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals("")){return ans;}
        }
        return ans;
    }
}
