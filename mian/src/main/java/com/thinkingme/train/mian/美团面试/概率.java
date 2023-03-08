package com.thinkingme.train.mian.美团面试;
/**
 * 一个函数A输出1的概率是p，另一个函数B输出0的概率是（1-p）
 * 实现一个函数输出0和1的概率一致。
 * @author Administrator
 *
 */
public class 概率 {
	private static int C() {
		int res;
		while(true) {
			int i = A();
			int j = B();
			if(i == 1&&j==0) {
				res = 1;
				break;
			}
			if(i==0&&j==1) {
				res = 0;
				break;
			}
		}
		return res;
		
	}

	private static int B() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int A() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 有rand7可以产生1-7的数字,求rand10
	 * @return
	 */
	//而随机发生器的作用就是产生各个位数的bi，
	//对于1~10，我们需要两个随机产生器 R1, R0,它们分别产生b1, b0。
	//那么它们可以产生的范围是8~56(1*7+1 ~ 7*7+7), 
	//总计49个数字，而且这49个数字出现的概率是相同的。然后我们截取40个数字，如 10~50，然后对10求余即可.

	int rand10()
	{
	    int a10;
	    do {
	        a10 = rand7() * 7 + rand7();
	    } while (a10<10 || a10 >50);
	                                                 
	    return a10%10 + 1; 
	}

	private int rand7() {
		// TODO Auto-generated method stub
		return 0;
	}
}
