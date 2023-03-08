package com.thinkingme.train.shua.快速幂;

public class 快速幂 {
	public static void main(String[] args) {
		System.out.println(fastPowerDFS(2, 4));
	}

	static long fastPower(long base, long power) {
	    long  result = 1;
	    while (power > 0) {
	        if ((power & 1) == 1) {//此处等价于if(power%2==1)
	            result = result * base /*% 1000*/;
	        }
	        power >>= 1;//此处等价于power=power/2
	        base = (base * base)/* % 1000*/;
	    }
	    return result;
	}
	static long fastPowerDFS(long base, long power) {
		if(power == 0)return 1;
		if(power%2 == 1){
			return base * fastPowerDFS(base,power-1);
		}else{
			return fastPowerDFS(base,power>>1) * fastPowerDFS(base,power>>1);
		}
	}
}
