package cn.thinkingme.train.mian.ShopeeCode;

import java.util.*;


public class Roma {
    /**
     * 
     * @param s string字符串 
     * @return int整型
     */
    public int romanToInt (String s) {
        char a[] = s.toCharArray();
        char last = 0;
        int num = 0;
        for(int i = a.length-1;i>=0;i--){
            switch(a[i]){
                    case 'I':
                        if(last == 'V'||last == 'X'){
                              num --;
                        }else num = num+1;
                        last = a[i];
                        break;
                    case 'V': 
                        num = num+5;
                        last = a[i];
                        break;
                    case 'X':
                        if(last == 'L'||last == 'C'){
                              num-=10;
                        }else num = num+10;
                        last = a[i];
                       break;
                    case 'L':
                        num = num+50;
                        last = a[i];
                       break;
                    case 'C':
                        if(last == 'D'||last == 'M'){
                              num-=100;
                        }else num = num+100;
                        last = a[i];
                       break;
                    case 'D':
                        num = num+500;
                        last = a[i];
                       break;
                    case 'M':
                        num = num+1000;
                        last = a[i];
                       break;
            }
        }
        return num;
    }
}