package com.thinkingme.train.shua.dataStructure;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 * 二叉树
 * </p>
 *
 * @author: huige
 * @date: 2022/8/31 10:14
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
    //字符串生成二叉树
    public static TreeNode createTree(String str){
        if (str==null) return null;
        String substring = str.substring(1, str.length() - 1);//掐头去尾
        if (substring.length()==0)return null;
        String[] split = substring.split(",");//按照逗号分割
        TreeNode root = split[0].equals("null")?null:new TreeNode(Integer.parseInt(split[0]));//树的root节点
        Queue<TreeNode> queue = new LinkedBlockingQueue<>(); //广度优先的辅助队列
        queue.add(root);
        int index = 1;//数组的索引下标
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (index<split.length){//如果下标越界就跳出while循环
                cur.left = split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.left!=null){//如果节点是null 就不放人队列
                    queue.add(cur.left);
                }
            }else {break;}
            if (index<split.length){//如果下标越界就跳出while循环
                cur.right= split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.right!=null){//如果节点是null 就不放人队列
                    queue.add(cur.right);
                }
            }else {break;}
        }
        return root;
    }
}

