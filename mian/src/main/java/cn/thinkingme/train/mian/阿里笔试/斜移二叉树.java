package cn.thinkingme.train.mian.阿里笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.InternalFrameUI;

public class 斜移二叉树 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		while(num-- != 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int a[]  =new int[n+1];
			for(int i = 1;i<=n;i++) {
				a[i] = i;
			}
			int h = (n+1) / 2;
			for(int i = n;i>n-h;i--) {
				int temp = i;
				ArrayList<Integer> arrayList = new ArrayList<>();
				arrayList.add(temp);
				while(temp%2 == 0) {
					temp = temp/2;
					arrayList.add(temp);
				}
				if(arrayList.size()>1)
					change(a,arrayList,k);
			}
			for(int i = 1;i<=n;i++) {
				if(i == n) {
					System.out.println(a[i]);
					break;
				}
				System.out.print(a[i]+" ");
			}
		}
		
	}
	private static void change(int a[], ArrayList<Integer> arrayList, int k) {
		k = k%arrayList.size();
		int begin = 0;
		int end = arrayList.size()-1;
		while(begin<end) {
			int temp = a[arrayList.get(begin)];
			a[arrayList.get(begin)] = a[arrayList.get(end)];
			a[arrayList.get(end)] = temp;
			begin++;
			end--;
		}
		begin = 0;
		end = k-1;
		while(begin<end) {
			int temp = a[arrayList.get(begin)];
			a[arrayList.get(begin)] = a[arrayList.get(end)];
			a[arrayList.get(end)] = temp;
			begin++;
			end--;
		}
		begin = k;
		end = arrayList.size()-1;
		while(begin<end) {
			int temp = a[arrayList.get(begin)];
			a[arrayList.get(begin)] = a[arrayList.get(end)];
			a[arrayList.get(end)] = temp;
			begin++;
			end--;
		}
	}

}
