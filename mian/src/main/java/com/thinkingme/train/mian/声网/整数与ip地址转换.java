package com.thinkingme.train.mian.声网;

import java.util.Scanner;

public class 整数与ip地址转换 {
	
	public static long ipToLong(String strIp) {
		String[]ip = strIp.split("\\.");
		return (Long.parseLong(ip[0])<<24)+(Long.parseLong(ip[1])<<16)+(Long.parseLong(ip[2])<<8)+Long.parseLong(ip[3]);
	}
	
	public static String longToIP(long longIp) {
		StringBuffer sb = new StringBuffer("");
		// 直接右移24位
		sb.append(String.valueOf((longIp >>> 24)));
		sb.append(".");
		// 将高8位置0，然后右移16位
		sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
		sb.append(".");
		// 将高16位置0，然后右移8位
		sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
		sb.append(".");
		// 将高24位置0
		sb.append(String.valueOf((longIp & 0x000000FF)));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String string = scanner.next();
			String string2 = scanner.next();
			
			String[] s = string.split("\\.");
			if(s.length>1) {
				StringBuffer sb = new StringBuffer();
				for(String a:s) {
					int x = Integer.parseInt(a);
					int arr[] = new int[8];
					for(int i=0;i<8;i++) {
						arr[i] = x%2;
						x /= 2; 
					}
					for(int i=7;i>=0;i--) {
						sb.append(arr[i]);		
					}
					
				}
				char c[] = sb.toString().toCharArray();
				long l = 0;
				int j = 0;
				for(int i = c.length-1;i>=0;i--,j++) {
					if(c[i] == '1')
					l  = l + (long)Math.pow(2, j);
				}
				System.out.println(l);
			}
			if(!string2.isEmpty()){
				StringBuffer sb = new StringBuffer();
				long l = Integer.parseUnsignedInt(string2);
				int arr[] = new int[32];

				for(int i=0;i<32;i++) {
					arr[i] = (int) (l%2);
					l /= 2; 
				}
				for(int i=31;i>=0;i--) {
					sb.append(arr[i]);		
				}

				for(int i=0;i<4;i++) {
					int h = i*8;
					String res = sb.substring(h, (i+1)*8);
					char c[] = res.toCharArray();
					long ans = 0;
					int j = 0;
					for(int m = c.length-1;m>=0;m--,j++) {
						if(c[m] == '1')
							ans  = ans + (long)Math.pow(2, j);
					}
					if(i == 3) {
						System.out.print(ans);
						break;
					}
					
					System.out.print(ans);
					System.out.print(".");
				}

			}
		}
		
	}
	
}

