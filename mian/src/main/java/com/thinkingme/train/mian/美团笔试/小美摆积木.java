package com.thinkingme.train.mian.美团笔试;

import java.util.Scanner;


/**
 * 题目描述：
小美想要为小团摆一行积木，每个积木上都有一个0-9的数字。现在已经摆好了 n 块积木，
小美可以把其中一块积木替换成任意一块积木（也可以不替换），使得积木看起来更符合小美的审美。请你帮小美看看，
替换后最好看的积木是什么样的。
摆好后的积木上面的数字，从左到右会形成一个数字串（由数字组成的字符串）。
小美会根据这个数字串来评判积木的好看程度，小美有两条审美标准：
①回文数字串相比于非回文数字串更符合小美的审美。例如：12321、2332是回文数字串，而12212、2121不是回文数字串。
②数字串形成的数字更小更好看。例如：1312比1313更好看，0102比1102更好看。
小美会按照她的审美标准来判断两个数字串哪个更好看，即先按照审美标准①判断，若无法判断再按审美标准②判断。

输入描述
第一行一个数 T，表示一共有 T 组测试数据。(1 ≤ T ≤ 100)。
接下来 T 组数据，每组数据两行，
第一行一个数 n，表示有 n 块积木。(1 ≤ n ≤ 20000)。
第二行 n 个数字，第 i 块积木上的数字是 si。(si是0-9的数字)。

输出描述
每组数据输出一行，表示最终摆好的积木形成的数字串。
 * @author Administrator
 *
 */
public class 小美摆积木 {
	public static int x = 0,y = 0;
	public static char node = 'o';
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while(scanner.hasNext()) {
			int m = scanner.nextInt();
			String string = scanner.next();
			char a[] = string.toCharArray();
			if(m == 1) {
				
			}else if(reverse(a) == 1) {
				char c = (char) Math.min(a[x],a[y]);
				a[x] = c;a[y] = c;
				
			}else if(x!=y){
				for(int i=0;i<a.length;i++) {
					if(a[i]==node) continue;
					else {
						a[i] = node;
						break;
					}
				}
			}
			for(int i=0;i<a.length;i++) {
				System.out.print(a[i]);
			}
		}
	}
	private static int reverse(char a[]) {
		int count = 0;
		int j = a.length-1;
		for(int i = 0;i<a.length/2;i++) {
			if(node == 'o') node = (char) Math.min(a[j] , a[i]);
			node = (char) Math.min(node, Math.min(a[j] , a[i]));
			if(a[i] == a[j]) { 
				j--;
				continue;
			}
			else { 
				count++;
				x = i;
				y = j;
				j--;
			}
		}
		node = (char) Math.min(node ,a[j]);
		return count;
	}

}
