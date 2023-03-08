package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * <p>
 * 715. Range 模块
 * </p>
 *
 * @author: huige
 * @date: 2022/6/20 10:01
 */
public class _715Range模块 {
}

/**
 * 有序列表
 */
class RangeModule {
    TreeMap<Integer,Integer> map;
    public RangeModule() {
        map=new TreeMap<>();
        map.put(-1,-1);
        map.put((int)1e9+5,(int)1e9+5);
    }

    public void addRange(int left, int right) {
        List<int[]> list=new ArrayList<>();
        while(true){
            int a=map.floorKey(left);
            if(map.get(a)>=left){
                list.add(new int[]{a,map.get(a)});
                map.remove(a);
            }
            else{break;}
        }
        while(true){
            int a=map.ceilingKey(left);
            if(a<=right){
                list.add(new int[]{a,map.get(a)});
                map.remove(a);
            }
            else{break;}
        }
        if(list.size()==0){map.put(left,right);}
        else{map.put(Math.min(list.get(0)[0],left),Math.max(right,list.get(list.size()-1)[1]));}
    }

    public boolean queryRange(int left, int right) {
        return map.get(map.floorKey(left))>=right;
    }

    public void removeRange(int left, int right) {
        List<int[]> list=new ArrayList<>();
        while(true){
            int a=map.floorKey(left);
            if(map.get(a)>left){
                list.add(new int[]{a,map.get(a)});
                map.remove(a);
            }
            else{break;}
        }
        while(true){
            int a=map.ceilingKey(left);
            if(a<=right){
                list.add(new int[]{a,map.get(a)});
                map.remove(a);
            }
            else{break;}
        }
        if(list.size()>0){
            if(list.get(0)[0]<left){map.put(list.get(0)[0],left);}
            if(list.get(list.size()-1)[1]>right){map.put(right,list.get(list.size()-1)[1]);}
        }
    }
}

/**
 * 线段树
 */
class RangeModule2 {
    class Node {
        Node ls, rs;
        int sum, add;
    }
    int N = (int)1e9 + 10;
    Node root = new Node();

    /**
     * @param node
     * @param lc 实际的左边界
     * @param rc 实际的有边界
     * @param l 任务左
     * @param r 任务右
     * @param v 坐标
     */
    void update(Node node, int lc, int rc, int l, int r, int v) {
        int len = rc - lc + 1;
        if (l <= lc && rc <= r) {
            node.sum = v == 1 ? len : 0;
            node.add = v;
            return ;
        }
        pushdown(node, len);
        int mid = lc + rc >> 1;
        if (l <= mid) update(node.ls, lc, mid, l, r, v);
        if (r > mid) update(node.rs, mid + 1, rc, l, r, v);
        pushup(node);
    }
    int query(Node node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return node.sum;
        pushdown(node, rc - lc + 1);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = query(node.ls, lc, mid, l, r);
        if (r > mid) ans += query(node.rs, mid + 1, rc, l, r);
        return ans;
    }
    void pushdown(Node node, int len) {
        if (node.ls == null) node.ls = new Node();
        if (node.rs == null) node.rs = new Node();
        if (node.add == 0) return ;
        int add = node.add;
        if (add == -1) {
            node.ls.sum = node.rs.sum = 0;
        } else {
            node.ls.sum = len - len / 2;
            node.rs.sum = len / 2;
        }
        node.ls.add = node.rs.add = add;
        node.add = 0;
    }
    void pushup(Node node) {
        node.sum = node.ls.sum + node.rs.sum;
    }
    public void addRange(int left, int right) {
        update(root, 1, N - 1, left, right - 1, 1);
    }
    public boolean queryRange(int left, int right) {
        return query(root, 1, N - 1, left, right - 1) == right - left;
    }
    public void removeRange(int left, int right) {
        update(root, 1, N - 1, left, right - 1, -1);
    }
}
