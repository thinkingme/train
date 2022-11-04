package cn.thinkingme.train.mian.vivo笔试;

public class ThreadPrint {
	public static Integer a = 1;
	public static void main(String[] args) {
		new A().start();
		new B().start();
		new C().start();
	}
	
}
class A extends Thread{
	@Override
	public void run() {
		while(true) {
			synchronized (ThreadPrint.a) {
				if(ThreadPrint.a == 1) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("A");
					ThreadPrint.a++;
				}
			}
		}
		
	}
}
class B extends Thread{
	@Override
	public void run() {
		while(true) {
			synchronized (ThreadPrint.a) {
				if(ThreadPrint.a == 2) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("B");
					ThreadPrint.a++;
				}
			}
		}
		
	}
}
class C extends Thread{
	@Override
	public void run() {
		while(true) {
			synchronized (ThreadPrint.a) {
				if(ThreadPrint.a == 3) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("C");
					ThreadPrint.a = 1;
				}
			}
		}
		
	}
}