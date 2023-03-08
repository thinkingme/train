package com.thinkingme.train.shua.刷题;

public class One2Nprint {
	public static void print1ToMaxOfNDigits(int n) {
	    if (n <= 0)
	        return;
	    char[] number = new char[n];
	    print1ToMaxOfNDigits(number, 0);
	}

	private static void print1ToMaxOfNDigits(char[] number, int digit) {
	    if (digit == number.length) {
	        printNumber(number);
	        return;
	    }
	    for (int i = 0; i < 10; i++) {
	        number[digit] = (char) (i + '0');
	        print1ToMaxOfNDigits(number, digit + 1);
	    }
	}

	private static void printNumber(char[] number) {
	    int index = 0;
	    while (index < number.length && number[index] == '0')
	        index++;
	    while (index < number.length)
	        System.out.print(number[index++]);
	    System.out.println();
	}
	public static void main(String[] args) {
		print1ToMaxOfNDigits(3);
	}
}
