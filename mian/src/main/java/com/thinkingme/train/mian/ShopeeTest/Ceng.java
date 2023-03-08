package com.thinkingme.train.mian.ShopeeTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Ceng {

    public static void main(String arg[]){
    	List<Object> list = new ArrayList<Object>();
        Scanner scan = new Scanner(System.in);
        String str = new String();
        str = scan.nextLine();
        String a[] = str.split(",");
        a[0] = a[0].substring(1);
        a[a.length-1]= a[a.length-1].substring(0, a[a.length-1].length()-1);
        for(String string : a) {
        	if(string.equals("#")) {
        		list.add(string);
        	}else {
        		list.add(Integer.parseInt(string));
        	}
        	
        }
        List<List<Object>> res = new ArrayList<List<Object>>(1);
        int pow = 1;
        int j = 0;
        for(int i =0;i<list.size();i++) {
        	List<Object> columnList = new ArrayList<Object>();
        	int x = j;
        	for(;j<pow+x&&j<list.size();j++) {
        		
        		if(!list.get(j).equals("#")) {
        			columnList.add(list.get(j));
            	}
            	
            }
        	res.add(i,columnList);
        	pow = (int) Math.pow(2, i+1);
        }
        System.out.print("[");
        for(int i=0;i<res.size();i++) {
        	if(res.get(i).size()>0) {
        		if(i == 0) {
        			System.out.print(res.get(i));
        		}else {
        			System.out.print("," + res.get(i));
        		}
        		
        	}
        }
        System.out.print("]");
    }
}
