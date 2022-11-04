package cn.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * <p>
 *522. 最长特殊序列 II
 * </p>
 *
 * @author: huige
 * @date: 2022/6/27 14:58
 */
public class _522最长特殊序列II {
    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"aba","cdc","eae"}));
    }
    public static int findLUSlength(String[] strs) {
        int max = -1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : strs) {
            max = Math.max(str.length(), max);
        }
        for (int i = max; i > 0; i--) {
            boolean contains = false;
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].length() == i){
                    hashMap.put(strs[j],hashMap.getOrDefault(strs[j],0)+1);
                }

            }

            if (hashMap.containsValue(1)){
                return i;
            }
        }
        return -1;
    }
}
