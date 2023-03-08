package com.thinkingme.train.shua.并查集;
/**
 * 
 * 
 * 给定一个帐户列表，每个元素accounts [i]是一个字符串列表，
 * 其中第一个元素accounts [i] [0]是账户名称，其余元素是这个帐户的电子邮件。
 *  现在，我们想合并这些帐户。 如果两个帐户有相同的电子邮件地址，则这两个帐户肯定属于同一个人。 
 *  请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为两个不同的人可能会使用相同的名称。
 *   一个人可以拥有任意数量的账户，但他的所有帐户肯定具有相同的名称。 合并帐户后，按以下格式返回帐户：
 *   每个帐户的第一个元素是名称，其余元素是按字典序排序后的电子邮件。 帐户本身可以按任何顺序返回。

输入描述
[

    ["John", "johnsmith@mail.com", "john00@mail.com"],

    ["John", "johnnybravo@mail.com"],

    ["John", "johnsmith@mail.com", "john_newyork@mail.com"],

    ["Mary", "mary@mail.com"]

]

输出描述
[

    ["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],

    ["John", "johnnybravo@mail.com"],

    ["Mary", "mary@mail.com"]

]

解释: 

第一个第三个John是同一个人的账户，因为这两个账户有相同的邮箱："johnsmith@mail.com".

剩下的两个账户分别是不同的人。因为他们没有和别的账户有相同的邮箱。
 */

import java.util.*;

public class 账户合并并查集 {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static List<List<String>> mergeAccount(List<List<String>> accounts) {
    	// 作用：存储每个邮箱属于哪个账户 ，同时 在遍历邮箱时，判断邮箱是否出现过[去重]
        // 格式：<邮箱，账户id>
        Map<String, Integer> emailToId = new HashMap<>();
        int n = accounts.size();//id个数
        UnionFind myUnion = new UnionFind(n);
        for(int i = 0; i < n; i++){
            int num = accounts.get(i).size();
            for(int j = 1; j < num; j++){
                String curEmail = accounts.get(i).get(j);
                //当前邮箱没有出现过
                if(!emailToId.containsKey(curEmail)){
                    emailToId.put(curEmail, i);
                }else{//当前邮箱已经出现过，那么代表这两个用户是同一个
                    myUnion.union(i, emailToId.get(curEmail));
                }
            }
        }
        //进行完上面的步骤，同一个用户的所有邮箱已经属于同一个连通域了，但是就算在同一个连通域，不同的邮箱还是可能会对应不同的id
        // 作用： 存储每个账户下的邮箱
        // 格式： <账户id, 邮箱列表> >
        // 注意：这里的key必须是账户id，不能是账户名称，名称可能相同，会造成覆盖
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        //将同一个连通域内的邮箱对应到同一个id【也就是第一次出现的id，比如4、5在同一个连通域，那么这个连通域对应的id就是4】
        for(Map.Entry<String, Integer> entry : emailToId.entrySet()){
            int id = myUnion.find(entry.getValue());
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());
            idToEmails.put(id,emails);
        }
        //经过上面的步骤，已经做到了id和邮箱集合对应起来，接下来把用户名对应起来就可以了
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()){
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(entry.getKey()).get(0));//先添加用户名
            tmp.addAll(emails);
            res.add(tmp);
        }
        return res;
        
    }
/******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _count = Integer.parseInt(in.nextLine());

        int _i = 0;
        List<List<String>> _accounts = new ArrayList<List<String>>();
        while (_i++ < _count) {
            String _line = in.nextLine();
            String[] _item = _line.split(",");
            _accounts.add(Arrays.asList(_item));
        }

        List<List<String>> res = mergeAccount(_accounts);

        Collections.sort(res, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                String aName1 = String.join(",", o1);
                String aName2 = String.join(",", o2);
                return aName1.compareTo(aName2);
            }

        });

        for (int res_i = 0; res_i < res.size(); res_i++) {
            List<String> resItem = res.get(res_i);
            System.out.println(String.join(",", resItem));
        }
    }
}
class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}


