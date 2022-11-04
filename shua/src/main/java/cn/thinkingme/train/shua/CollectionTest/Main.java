package cn.thinkingme.train.shua.CollectionTest;

class A{
	static int i =0;
	public void iii() {
		System.out.println("AVDV");
	}
	public void name() { 
		
		try {
			i++;
			name();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("stack height:"+i);
        }
	}
}

public class Main extends A {
	public static void main(String[] args) {
		new A().name();
	}


}
