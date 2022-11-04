package cn.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 589. N 叉树的前序遍历
 * </p>
 *
 * @author: huige
 * @date: 2022/3/10 15:56
 */
public class _589N叉树的前序遍历 {
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
    }
    public static void main(String[] args) {

    }
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        //递归版

        if(root == null)
            return res;
        res.add(root.val);
        for(Node child:root.children)
        {
            preorder(child);
        }

        return res;
    }
}
