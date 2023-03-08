package com.thinkingme.train.shua.并发;

public class Test {
	Integer oInteger = 2;
	public void put() {
		synchronized (oInteger) {
			synchronized (oInteger) {
				System.out.println("进入了！");
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(()->{
			new Test().put();
		},"重入").start();
	}
}
