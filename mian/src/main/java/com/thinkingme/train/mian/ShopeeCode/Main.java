package com.thinkingme.train.mian.ShopeeCode;

import java.util.*;

public class Main{
    public static void main(String arg[]){
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            StringBuffer str = new StringBuffer(scan.next());
            char s[] = str.toString().toCharArray();
            int j = 1;
            for(int i= 1;i<s.length;i++,j++){
                if(s[i]<='Z'&&s[i]>='A'){
                    str.insert(j,'-');
                    j++;
                }
            }
            String res[] = str.toString().split("-|_");
//            for(int i=0;i<res.length;i++) {
//            	System.out.println(res[i]);
//            }
            String res2[] = {"","","",""};
            for(int i=0;i<res.length;i++) {
				res2[0] +=toUpCase(res[i]);
            }
        	for(int i=0;i<res.length;i++) {
        		if(i ==0)res2[1] = toLowCase(res[i]);
        		else {
					res2[1] += toUpCase(res[i]);
				}
            }
        	
        	for(int i=0;i<res.length;i++) {
        		if(i ==0)
        			res2[3] = toLowCase(res[i]);
        		else {
        			res2[3] = res2[3] + "-"+toLowCase(res[i]);
				}
            }
        	for(int i=0;i<res.length;i++) {
        		if(i ==0)
        			res2[2] = toLowCase(res[i]);
        		else {
					res2[2] = res2[2] + "_"+toLowCase(res[i]);
				}
            }
        	
        	System.out.println(res2[0]+" "+res2[1]+" "+res2[2]+" "+res2[3]);
        	System.out.println(~5);
        }
    }
    public static String toLowCase(String str) {
    	char s[] = str.toCharArray();
		if(str.charAt(0)<='z'&&str.charAt(0)>='a') {
			return str;
		}else {
			s[0] +=32;
		}
    	return String.valueOf(s);
	}
    public static String toUpCase(String str) {
		
    	char s[] = str.toCharArray();
		if(str.charAt(0)<='Z'&&str.charAt(0)>='A') {
			return str;
		}else {
			s[0] -=32;
		}
    	return String.valueOf(s);
	}
    
    
}