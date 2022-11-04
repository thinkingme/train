package cn.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _49
 * @Author: huige
 * @Description: 字母异位词分组
 * @Date: 2021/10/11 11:13
 * @Version: 1.0
 */
public class _49 {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Set<String> s = new HashSet<>();
        Map<String,List<String>> lists = new HashMap<>();
        Arrays.stream(strs).forEach(a->{
            char[] arrayCh=a.toCharArray();
            Arrays.sort(arrayCh);
            String sortedStr=new String(arrayCh);
            lists.put(sortedStr,lists.getOrDefault(sortedStr,new ArrayList<>()));
            lists.get(sortedStr).add(a);

        });
        Collection<List<String>> valueCollection = lists.values();  //获取map所有的value

        List<List<String>> valueList = new ArrayList<List<String>>(valueCollection);

        System.out.println(Collections.singletonList(lists.values()));
        return valueList;
    }
}
