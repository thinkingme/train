package cn.thinkingme.train.mian.ShopeeTest;

import java.util.*;

public class Version{

    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        char s1[] = scan.next().toCharArray();
        char s2[] = scan.next().toCharArray();
        
        for(int i = 0;i<s1.length;i++) {
        	if(s1[i]!='“'&&s1[i]!='”'&&s1[i]!=',') {
        		sb1.append(s1[i]);
        	}
        }
        for(int i = 0;i<s2.length;i++) {
        	if(s2[i]!='“'&&s2[i]!='”'&&s2[i]!=',') {
        		sb2.append(s2[i]);
        	}
        }
        String []str1 = sb1.toString().split("\\.");
        String []str2 = sb2.toString().split("\\.");
        int res1 = 0,res2 = 0;
        if(str1.length ==str2.length)
        {
        	int i = 0;
        	for(;i<str1.length;i++) {
            	if(Integer.parseInt(str1[i])>Integer.parseInt(str2[i])) {
            		System.out.println(1);
            		break;
            	}else if(Integer.parseInt(str1[i])<Integer.parseInt(str2[i])) {
            		System.out.println(-1);
            		break;
            	}
            }
        	if(i == str1.length) System.out.println(0);
        }
        if(str1.length < str2.length)
        {
        	int i = 0 , j=str1.length;
        	for(;i<str1.length;i++) {
            	if(Integer.parseInt(str1[i])>Integer.parseInt(str2[i])) {
            		System.out.println(1);
            		break;
            	}else if(Integer.parseInt(str1[i])<Integer.parseInt(str2[i])) {
            		System.out.println(-1);
            		break;
            	}
            }
        	if(i == str1.length ) {
        		for(;j<str2.length;j++) {
        			if(Integer.parseInt(str2[j])!=0) {
        				System.out.println(-1);
        				break;
        			}
        		}
        	}
        	if(j==str2.length)System.out.println(0);
        }
        if(str1.length > str2.length)
        {
        	int i = 0 , j=str2.length;
        	for(;i<str2.length;i++) {
            	if(Integer.parseInt(str1[i])>Integer.parseInt(str2[i])) {
            		System.out.println(1);
            		break;
            	}else if(Integer.parseInt(str1[i])<Integer.parseInt(str2[i])) {
            		System.out.println(-1);
            		break;
            	}
            }
        	if(i == str2.length ) {
        		for(;j<str1.length;j++) {
        			if(Integer.parseInt(str1[j])!=0) {
        				System.out.println(1);
        				break;
        			}
        		}
        	}
        	if(j==str1.length)System.out.println(0);
        }
        
        
    }



}