package cn.thinkingme.train.mian.奇安信;

import java.util.Scanner;

public class 体积最大值 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(getMaxVolume(scanner.nextLong()));
		System.out.println(is_digit(9));
	}
	
	 public static long getMaxVolume (long n) {
		 long max = 0;
	        // write code here
		 for(long i =2;i<n;i++) {
			 if(is_digit(i)) {
				 for(long j =2;j<n - i;j++) {
					 if(is_digit(j) && is_digit(n-i-j)) {
						max = Math.max(max, i*j*(n-i-j));
					 }
				 }
			 }
			 
		 }
		 return max;
	 }
	 public static boolean is_digit(long num) {
		 if(num == 2 )return true;
		for(long i = 2;i<=(long) Math.sqrt(num);i++) {
			if(num%i == 0)return false;
		}
		return true;
	}
}
