package com.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * 429. N 叉树的层序遍历
 * </p>
 *
 * @author: huige
 * @date: 2022/4/8 15:56
 */
public class _429N叉树的层序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> nodes = new LinkedList<>(root.children);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>(){
            {add(root.val);}
        });
        while(!nodes.isEmpty()){

            int n = nodes.size();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node poll = nodes.poll();
                integers.add(poll.val);
                nodes.addAll(poll.children);
            }
            res.add(integers);
        }
        return res;
    }
}
