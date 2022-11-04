package cn.thinkingme.train.mian._360笔试;

import java.util.Scanner;

/**
 * 小马最近找到了一款打气球的游戏。
每一回合都会有n个气球，每个气球都有对应的分值，第i个气球的分值为ai。
这一回合内，会给小马两发子弹，但是由于小马的枪法不准，一发子弹最多只能打破一个气球，甚至小马可能一个气球都打不中。
现给出小马的得分规则：
1. 若小马一只气球都没打中，记小马得0分。
2. 若小马打中了第i只气球，记小马得ai分。
3. 若小马打中了第i只气球和第j只气球（i＜j），记小马得ai|aj分。
（其中 | 代表按位或，按位或的规则如下：
参加运算的两个数，按二进制位进行或运算，只要两个数中的一个为1，结果就为1。
即 0|0=0,1|0=1，1|1=1。
例：2|4即00000010|00000100=00000110，所以2|4=6 ）
现在请你计算所有情况下小马的得分之和。

输入描述
第一行，一个整数n，表示此回合的气球数量。
第二行，用空格分开的n个整数，第i个整数为ai，表示每个气球对应的分值。
1≤n≤50000,1≤ai≤100000
输出描述
一行一个整数，代表所有情况下小马的得分之和。

样例输入
3
1 2 3
样例输出
15
 * @author Administrator
 *
 */
public class 神枪手 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int score[] = new int[n];
			long res = 0;
			for(int i=0;i<n;i++) {
				score[i] = scanner.nextInt();
				res += score[i];
			}
			for(int i=0;i<n-1;i++) {
				for(int j = i+1;j<n;j++) {
					res = res + (score[i]|score[j]);
				}
			}
			System.out.print(res);
		}
	}

}
