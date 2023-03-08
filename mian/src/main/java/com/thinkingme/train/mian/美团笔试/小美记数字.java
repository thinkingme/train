package com.thinkingme.train.mian.美团笔试;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 小美的记忆力超级棒，小团决定来考一考小美。
 * 小团给了小美 n 个数，从左到右排成一行，给了1 分钟让小美记住。
 * 然后小团会询问 m 次，每次都问数 x 第一次出现的位置和最后一次出现的位置，
 * 若数 x 没出现过，那么回答 0 即可。小美的记忆力好，但是 1 分钟记住这么多数实在是太难了，
 * 请你帮帮小美，完成这次不可能的挑战。

输入描述
第一行两个数 n, m。(1 ≤ n, m ≤ 50000)。

第二行 n 个数，第 i 个数是 ai。(1 ≤ ai ≤ 1000000000)。

接下来 m 行，每行一个数 x (1 ≤ x ≤ 1000000000)，代表一次询问。

输出描述
输出 m 行，若数 x 出现过，输出数 x 第一次出现的位置和最后一次出现的位置。若数 x 没出现过，输出 0。
 * @author Administrator
 *
 */
public class 小美记数字 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(),m = scanner.nextInt();
		long num[] = new long[n];
		long check[] = new long[m];
		for(int i = 0;i<n;i++) {
			num[i] = scanner.nextLong();
		}
		for(int i = 0;i<m;i++) {
			check[i] = scanner.nextLong();
		}
		HashMap<Long, Integer> FirstHM = new HashMap<>(); 
		HashMap<Long, Integer> LastHM = new HashMap<>(); 
		for(int i = 0;i<n;i++) {
			if(FirstHM.containsKey(num[i])) {
				LastHM.put(num[i], i+1);
			}else {
				FirstHM.put(num[i], i+1);
			}
		}
		for(int i = 0;i<m;i++) {
			if(FirstHM.containsKey(check[i])&&LastHM.containsKey(check[i])) {
				System.out.println(FirstHM.get(check[i])+" "+LastHM.get(check[i]));
			}else if(FirstHM.containsKey(check[i])) {
				System.out.println(FirstHM.get(check[i])+" "+FirstHM.get(check[i]));
			}else {
				System.out.println("0");
			}
		}
	}
}
