package com.thinkingme.train.shua.剑指;


import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 剑指 Offer 07. 重建二叉树
 * </p>
 *
 * @author: huige
 * @date: 2022/8/29 8:55
 */
public class _1_7 {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
    }
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left>preorder_right){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preorder_left]);
        Integer integer = indexMap.get(preorder[preorder_left]);
        int size = integer - inorder_left;
        treeNode.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size,inorder_left,integer-1);
        treeNode.right = myBuildTree(preorder,inorder,preorder_left+size+1,preorder_right,integer+1,inorder_right);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
