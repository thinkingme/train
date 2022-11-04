package cn.thinkingme.train.mian.跟谁学;

import java.util.Scanner;

public class 基因序列 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String string = scanner.next();
		int sum = 0;
		int l = string.indexOf("ATG");
		int x = string.indexOf("TAA");
		int y = string.indexOf("TAG");
		int z = string.indexOf("TGA");
		int h = -1;
		if(l<x && (x-l)%3 == 0) {
			h = x;
		}
		if(l<y && (y-l)%3 == 0) {
			if(y<h)h = y;
			if(h == -1) h = y;
		}
		if(l<z && (z-l)%3 == 0) {
			if(z<h)h = z;
			if(h == -1) h = z;
		}
		while(l != -1&&h != -1) {
			int last = h;
			sum++;
			l = string.indexOf("ATG", h+3);
			x = string.indexOf("TAA", h+3);
			y = string.indexOf("TAG", h+3);
			z = string.indexOf("TGA", h+3);
			if(l<x && (x-l)%3 == 0) {
				h = x;
			}
			if(l<y && (y-l)%3 == 0) {
				if(h == last) h = y;
				else if(y<h)h = y;
			}
			if(l<z && (z-l)%3 == 0) {
				if(h == last) h = z;
				else if(z<h)h = z;
			}
			if(x == -1&&y == -1&&z == -1) h = -1;
		}
		System.out.print(sum);
	}
}
