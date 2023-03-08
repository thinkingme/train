package com.thinkingme.train.shua.刷题;

public class ReceiveRainwater {
	
	public static int solute(int[] height) {
		int count = 0;
		int i=0,j=0;
		while(i<height.length-1) {
			
			for(j = i+1;j<height.length;j++) {
				if(height[i]>height[j]) {
					continue;
				}else {
					for(int h = i+1 ; h<j;h++) {
						count+= (height[i]-height[h]);
					}
					i = j;
					break;
				}
			}
			if(i!=j) {
				
				j =j-1;
				int x=j;
				while(x>i) {
					
					for(x=j-1 ; x >= i ;x--) {
						if(height[j]>height[x]) {
							continue;
						}else {
							for(int h = x+1 ; h<j;h++) {
								count+= (height[j]-height[h]);
							}
							j = x;
							break;
						}
					}
				}
				break;
			}
					
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int height[] = {4,2,3};
		System.out.println(solute(height));
	}
}
