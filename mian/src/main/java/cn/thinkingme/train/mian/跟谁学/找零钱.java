package cn.thinkingme.train.mian.跟谁学;

import java.util.Scanner;

public class 找零钱 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int b[] = {100,50,20,10,5,1};
			int a[] = new int[6];
			for(int i=0;i<6;i++) {
				a[i] = n/b[i];
				n = n%b[i];
			}
			for(int i=0;i<6;i++) {
				if(i == 5)System.out.print(a[i]);
				else System.out.print(a[i]+" ");
			}
		}
	}
}
