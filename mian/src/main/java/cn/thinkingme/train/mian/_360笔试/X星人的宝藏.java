package cn.thinkingme.train.mian._360笔试;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;



/**
 * X星人发现了一个藏宝图，在藏宝图中标注了N个宝库的位置。这N个宝库连成了一条直线，每个宝库都有若干枚金币。
X星人决定乘坐热气球去收集金币，热气球每次最多只能飞行M千米（假设热气球在飞行过程中并不会发生故障）此外，
由于设计上的缺陷，热气球最多只能启动K次。
X星人带着热气球来到了第1个宝库（达到第1个宝库时热气球尚未启动），
收集完第1个宝库的金币后将启动热气球前往下一个宝库。如果他决定收集某一个宝库的金币，必须停下热气球，
收集完之后再重新启动热气球。
当然，X星人每到一个宝库是一定会拿走这个宝库所有金币的。
已知每一个宝库距离第1个宝库的距离（单位：千米）和宝库的金币数量。
请问X星人最多可以收集到多少枚金币？

输入描述
单组输入。

第1行输入三个正整数N、M和K，分别表示宝库的数量、热气球每次最多能够飞行的距离（千米）和热气球最多可以启动的次数，
三个正整数均不超过100，相邻两个正整数之间用空格隔开。
接下来N行每行包含两个整数，分别表示第1个宝库到某一个宝库的距离（千米）和这个宝库的金币枚数。
（因为初始位置为第1个宝库，因此第1个宝库所对应行的第1个值为0。）
输入保证所有的宝库按照到第1个宝库的距离从近到远排列，初始位置为第1个宝库。

输出描述
输出一个正整数，表示最多可以收集的金币数。

样例输入
5 10 2
0 5
8 6
10 8
18 12
22 15
样例输出
25
 * @author Administrator
 *
 */
public class X星人的宝藏 {
	public static Stack<Integer> stack = new Stack<>();
	public static long max = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(),m = scanner.nextInt(),k = scanner.nextInt();
		int a[][] = new int[n][2];
		for(int i = 0;i<n;i++) {
			a[i][0] = scanner.nextInt();
			a[i][1] = scanner.nextInt();
		}
		stack.add(a[0][0]);
		System.out.print(gui(a, m, k));
		choose(a, k, 1, 0, 0, m);
		System.out.print(max + a[0][1]);
	}
	private static void choose(int num[][] ,int k, int cur,int has,int m,int dis) {
		if(k == has ) {
			return ;
		}
		for(int i=cur;i<num.length;i++) {
			if(!stack.contains(num[i][0])&&num[i][0] - stack.peek()<=dis) {
				stack.add(num[i][0]);
				m +=num[i][1];
				max = Math.max(max,m);
				choose(num, k, i, has+1,m,dis);
				m -= num[i][1];
				stack.pop();
			}
			
		}

	}
	/**
	 * 动态规划法
	 * @param num
	 * @param m
	 * @param k
	 * @return
	 */
	private static int gui(int num[][],int m , int k) {
		int n = num.length;
		int ans = num[0][1];
		int dp[][] = new int[n][k+1];
		for(int[] i:dp) {
			Arrays.fill(i, -1);
		}
		dp[0][0] = num[0][1];
		for(int i = 1;i<n;i++) {
			for(int j = 1;j<=k;j++) {
				for(int z = 0;z<i;z++) {
					if(num[i][0] - num[z][0]  <= m ) {
						if( dp[z][j-1] != -1) {
							dp[i][j] =  Math.max(dp[i][j], dp[z][j-1]+num[i][1]);
							ans = Math.max(ans,dp[i][j]);
						}
							
					}
				}
			}
		}
		return ans;
	}
}
