package cn.thinkingme.train.test;

import java.util.*;


public class TestHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> tMap = new TreeMap<String, String>();
        for (int i = 0; i < 10; i++) {
        	map.put("key" + i, "value" + i);
        }
        for (int i = 0; i < 10; i++) {
        	tMap.put("key" + i, "value" + i);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "..." + entry.getValue());
        }
        System.out.println();
        for (String key : map.keySet()) {
            System.out.println(key + "..." + map.get(key));
        }
        System.out.println("-----------");
        for (Map.Entry<String, String> entry : tMap.entrySet()) {
            System.out.println(entry.getKey() + "..." + entry.getValue());
        }
        System.out.println();
        for (String key : tMap.keySet()) {
            System.out.println(key + "..." + tMap.get(key));
        }
	}
}




