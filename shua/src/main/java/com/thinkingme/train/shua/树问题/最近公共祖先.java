package com.thinkingme.train.shua.树问题;

public class 最近公共祖先 {
	
	private static TreeNode LCS(TreeNode root,TreeNode p,TreeNode q) {
		if(root == null || root == p || root == q) return root;
		
		TreeNode left = LCS(root.left, p,q);
		TreeNode right = LCS(root.right, p,q);
		
		if(left != null&&right != null) {
			return root;
		}else if(left != null){
			return left;
		}else {
			return right;
		}
		
	}
}
class TreeNode{
	TreeNode left;
	TreeNode right;
}
