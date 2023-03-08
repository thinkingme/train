package com.thinkingme.train.mian.字节跳动笔试;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**

给定n个猴子 每个猴子有个食量，每个猴子轮流拿香蕉，
要求拿的数量为min(remain/2,eat*2)且该数量>eat，
其中remain是当前剩余食物数量，eat是食量。最后一个猴子可以全部拿走，
求最小的食物数量使得每个人都能吃饱。
1<=n<=200
 * @author Administrator
 *
 */
public class Monkey {
	public static boolean check(int mid ,ArrayList<Integer>arrayList) {
		for (int i = 0; i + 1 < arrayList.size(); i++) {
		    int num = Math.min(mid / 2, arrayList.get(i) * 2);
		    if (num < arrayList.get(i)) return false;
		    mid -= num;
		  }
		  if (mid < arrayList.get(arrayList.size()-1)) return false;
		  return true;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int l = 1,r = (int) (1e9+7);
		while(scanner.hasNextInt()) {
			arrayList.add(scanner.nextInt());
		}
		while (l < r) {
		    int mid = (l + r) >> 1;
		    if (check(mid,arrayList)) {
		      r = mid;
		    } else {
		      l = mid + 1;
		    }
		  }
		System.out.println(l);
	}
}
