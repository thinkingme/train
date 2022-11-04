package cn.thinkingme.train.shua.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: TreeNode
 * @Author: huige
 * @Description: 树
 * @Date: 2021/7/28 14:31
 * @Version: 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode buildTree(Integer[] arr){
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1; i < arr.length; i++){
            TreeNode node = queue.peek();
            TreeNode son = arr[i] == null? null:new TreeNode(arr[i]);
            if((i&1) == 1){
                if(node != null){
                    node.left = son;
                }
            } else{
                if(node != null){
                    node.right = son;
                }
                queue.poll();
            }
            queue.add(son);
        }
        return root;
    }
}
