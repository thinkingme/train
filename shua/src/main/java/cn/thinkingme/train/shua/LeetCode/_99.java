package cn.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;

public class _99 {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		TreeNode lNode = root.left;
		lNode.right = new TreeNode(2);
		recoverTree(root);
		System.out.println();
		midDfs(root, arrayList);
	}
	
	public static void recoverTree(TreeNode root) {
		int small = 0,big = 0;
		ArrayList<Integer> arrayList = new ArrayList<>();
		midDfs(root, arrayList);
		for (int i = 0; i < arrayList.size()-1; i++) {
			if(arrayList.get(i)<arrayList.get(i+1)) {
				continue;
			}else {
				big = arrayList.get(i);
				break;
			}
		} 
		for (int i = arrayList.size()-1; i > 0; i--) {
			if(arrayList.get(i)>arrayList.get(i-1)) {
				continue;
			}else {
				small = arrayList.get(i);
				break;
			}
		}
		midDfs2(root, small, big);
    }
	
    public static void midDfs(TreeNode root,ArrayList<Integer> arrayList){
        if(root == null) return;
        
        midDfs(root.left,arrayList);
        arrayList.add(root.val);
        System.out.print(root.val+",");
        midDfs(root.right,arrayList);
    }
    public static void midDfs2(TreeNode root,int small,int big){
        if(root == null) return;
        
        midDfs2(root.left, small, big);
        if(root.val == big) {
        	root.val = small;
        }else if(root.val == small) {
        	root.val = big;
        }
        midDfs2(root.right, small, big);
    }
}
