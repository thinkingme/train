package com.thinkingme.train.mian.贝壳笔试;

import java.util.HashMap;
import java.util.Scanner;

public class _1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int res = 0;
		HashMap<String, Integer> store = new HashMap<>();
		HashMap<String, Integer> val = new HashMap<>();

		for(int i = 0;i<n;i++) {
			String name = scn.next();
			val.put(name, scn.nextInt());
			store.put(name, scn.nextInt());		
		}

		for(int i = 1;i<=m;i++) {
			String name = scn.next();
			int need = scn.nextInt();
			if(store.get(name)>= need) {
				res += val.get(name)*need;
				store.put(name, store.get(name) -need);
			}else {
				res = -i;
				break;
			}
		}
		System.out.println(res);
	}
}
