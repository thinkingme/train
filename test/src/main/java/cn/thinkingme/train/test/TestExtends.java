package cn.thinkingme.train.test;

class father{
	public void name() {
		System.out.println("father:"+this);
	}
}
class son extends father{
	@Override
	public void name() {
		System.out.println(this);
		super.name();
	}
}
public class TestExtends {
	public static void main(String[] args) {
		new son().name();
	}
}
