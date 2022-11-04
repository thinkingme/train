package cn.thinkingme.train.shua.LeetCode;

import java.util.LinkedList;
import java.util.Queue;


public class 剑指offer37 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		serialize(root);
	}
	public static String serialize(TreeNode root) {
	   if(root == null){
	       return "null,";
	   }
	   String res = root.val + ",";
	   res += serialize(root.left);
	   res += serialize(root.right);
	   return res;
	}

	//Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
	   String[] arr = data.split(",");
	   Queue<String> queue = new LinkedList<String>();
	   for(int i = 0; i < arr.length; i++){
	       queue.offer(arr[i]);
	   }
	   return help(queue);
	}
	public static TreeNode help(Queue<String> queue){
	   String val = queue.poll();
	   if(val.equals("null")){
	       return null;
	   }
	   TreeNode root = new TreeNode(Integer.valueOf(val));
	   root.left = help(queue);
	   root.right = help(queue);
	   return root;
	}
}