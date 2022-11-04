package cn.thinkingme.train.mian.贝壳笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class _2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			arrayList.add(scn.nextInt());
		}
		Collections.sort(arrayList);
		int res = 0;
		
		while(arrayList.size()>0) {
			Iterator<Integer> itr = arrayList.iterator();
			Integer tempInteger = 0;
			while(itr.hasNext()) {
				Integer integer = itr.next();
				if(!integer.equals(tempInteger)) {
					itr.remove();
				}
				tempInteger = integer;
				
			}
			res +=1;
		}
		System.out.println(res);
	}
}
