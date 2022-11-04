package cn.thinkingme.train.shua.刷题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Temp {
	public static void main(String[] args) {
		int a[][] = {{3,2,1},{20,2,10},{6,2,9}};
		int b[] = {3,2,1};
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < b.length; i++) {
            arrayList.add(b[i]); //存放元素
        }
		int[] copyOf = Arrays.copyOf(b, 2);
		System.out.println(Arrays.toString(copyOf));
		Collections.reverse(arrayList);
		//Arrays.sort(a);
		System.out.println(arrayList);
	}
}
