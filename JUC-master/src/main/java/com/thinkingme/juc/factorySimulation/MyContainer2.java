/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 
 * 使用wait和notify/notifyAll来实现
 * 
 * 使用Lock和Condition来实现
 * 对比两种方式，Condition的方式可以更加精确的指定哪些线程被唤醒
 * 
 * @author thinkingme
 */
package com.thinkingme.juc.factorySimulation;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 工厂生产消费模拟
 *
 *  // 为什么多线程同步的时候 要用while而不是if
 *         //A线程和B线程在执行 get 方法的时候，由于list 的 size 为 0， 所以A和B线程都执行wait方法阻塞住并且释放了锁。
 *         //C 线程执行put操作是，调用 notifyAll() 方法唤醒A和B线程，假设是A线程先获得锁，那么A remove 后，现在 list 的大小又为 0 了
 *         // 此时线程A调用 notifyAll 方法来唤醒B线程，那么B线程获得锁之后，会直接调用 remove 方法，此时 list 的大小为0，所以报 IndexOutOfBoundsException
 *         // 解决方法就是将 if 改为 while 就好了，因为 是while的话， 此时线程A调用 notifyAll 方法来唤醒B线程，那么B线程获得锁之后 会执行 while 语句，判断 size == 0，执行 wait 方法
 * @param <T>
 */
public class MyContainer2<T> {
	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 10; //最多10个元素
	private int count = 0;
	
	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();
	
	public void put(T t) {
		try {
			lock.lock();
			while(lists.size() == MAX) { //想想为什么用while而不是用if？
				producer.await();
			}
			lists.add(t);
			++count;
			consumer.signalAll(); //通知消费者线程进行消费
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public T get() {
		T t = null;
		try {
			lock.lock();
			while (lists.size() == 0) {
				consumer.await();
			}
			t = lists.removeFirst();
			count --;
			producer.signalAll(); //通知生产者进行生产
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer2<String> c = new MyContainer2<>();
		//启动消费者线程
		for(int i=0; i<10; i++) {
			new Thread(()->{
				for(int j=0; j<5; j++) System.out.println(c.get());
			}, "c" + i).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//启动生产者线程
		for(int i=0; i<2; i++) {
			new Thread(()->{
				for(int j=0; j<25; j++) c.put(Thread.currentThread().getName() + " " + j);
			}, "p" + i).start();
		}
	}
}
