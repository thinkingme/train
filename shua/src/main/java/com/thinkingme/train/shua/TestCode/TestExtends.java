package com.thinkingme.train.shua.TestCode;

class father{
	public void name() {
		System.out.println(this);
	}
}
class son extends father{
	@Override
	public void name() {
		//System.out.println(this);
		//super.name();
	}
}
public class TestExtends {
	public static void main(String[] args) {
		System.out.println("asdasd");
		//new father().name();
	}
}
