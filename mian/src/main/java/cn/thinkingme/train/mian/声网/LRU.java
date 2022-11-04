package cn.thinkingme.train.mian.声网;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LRU {
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		int n= scanner.nextInt();
		int k = scanner.nextInt();
		/**
		 * 重写自带方法实现LRU
		 * 
		 */
		Map < Integer, Integer > hs = new LinkedHashMap < Integer, Integer > () {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry < Integer, Integer > eldest) {
                return size() > k;
            }
        };

		while(scanner.hasNextInt()) {
			int code = scanner.nextInt();
			if(code == 1) {
				int key = scanner.nextInt();
				int val = scanner.nextInt();
				//zif(hs.size()<k) {
					hs.put(key, val);
//				}else {
//					if(hs.containsKey(key)) {
//						hs.remove(key);
//						hs.put(key, val);
//					}else{
//						for (Integer p : hs.keySet()) {
//				            hs.remove(p);
//				          
//				            break;
//				        }
//						hs.put(key, val);
//					}
//				}
			}else if(code ==2){
				int key = scanner.nextInt(); 
				if(hs.containsKey(key)) {
					int val = hs.get(key);
					System.out.println(val);
					//hs.remove(key);
					hs.put(key, val);
				}else {
					System.out.println("-1");
				}
			}
			
		}
	}
}
