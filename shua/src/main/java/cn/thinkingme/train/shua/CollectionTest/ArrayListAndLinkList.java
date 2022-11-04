package cn.thinkingme.train.shua.CollectionTest;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayListAndLinkList {
	public static final int initSize = 100000;
	public static final int changeSize = 400000;

	private static ArrayList<Integer> arrayList = new ArrayList<>(initSize+changeSize);
	private static LinkedList<Integer> linkedList = new LinkedList<>();

	private static final Random random = new Random();
	private static void initElems() {
		arrayList.clear();
		IntStream.range(0,initSize).forEach(i -> {
			arrayList.add(i);
			linkedList.add(i);
		});
	}
	private static void randomInsert(ArrayList<Integer> arrayList,int size) {
		long start = System.currentTimeMillis();
		IntStream.range(0,size).forEach(i -> {
			arrayList.add(random.nextInt(initSize+i),i);
		});
		long end = System.currentTimeMillis();
		System.out.println("ArrayList randomInsert cost:"+(end-start)+"ms");
	}

	private static void randomInsert(LinkedList<Integer> linkedList,int size) {
		long start = System.currentTimeMillis();
		IntStream.range(0,size).forEach(i -> {
			linkedList.add(random.nextInt(initSize+i),i);
		});
		long end = System.currentTimeMillis();
		System.out.println("LinkedList randomInsert cost:"+(end-start)+"ms");
	}
	public static void main(String[] args) {

		initElems();
		randomInsert(arrayList, 2);
		randomInsert(linkedList, 2);

	}
}
