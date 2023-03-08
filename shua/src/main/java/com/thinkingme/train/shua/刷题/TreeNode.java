package com.thinkingme.train.shua.刷题;
import java.util.ArrayList;
import java.util.List;
public class TreeNode {
	public static TreeNode p = null;
	public static TreeNode q = null;
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;
//	    数据域
    private Object val;
    //    存节点
    public List<TreeNode> vals;
 
    public TreeNode(TreeNode left, TreeNode right, Object val){
        this.left=left;
        this.right=right;
        this.val=val;
    }
//	    将初始的左右孩子值为空
    public TreeNode(Object val){
        this(null,null,val);
    }
 
    public TreeNode() {
 
    }
 
    public void creat(Object[] objs){
        vals=new ArrayList<TreeNode>();
        //        将一个数组的值依次转换为Node节点
        for(Object o:objs){
            vals.add(new TreeNode(o));
        }
        //	        第一个数为根节点
        root=vals.get(0);
        //	        建立二叉树
        for (int i = 0; i <objs.length/2; i++) {
        	//	            左孩子
            vals.get(i).left=vals.get(i*2+1);
            //	            右孩子
            if(i*2+2<vals.size()){//避免偶数的时候 下标越界
                vals.get(i).right=vals.get(i*2+2);
            }
        }
    }

    public static void getNodeP(TreeNode root,Object val){
        if(root!=null){
            if(root.val == val) p =  root;
            getNodeP(root.left, val);
            getNodeP(root.right, val);
        }

    }
    public static void getNodeQ(TreeNode root,Object val){
        if(root!=null){
            if(root.val == val) q =  root;
            getNodeQ(root.left, val);
            getNodeQ(root.right, val);
        }

    }
	//先序遍历
	public void preorder(TreeNode root){
	    if(root!=null){
	        System.out.println(root.val);
	        preorder(root.left);
	        preorder(root.right);
	    }
	}
	//中序遍历
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }
    //	    后序遍历
    public void afterorder(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            afterorder(root.left);
            afterorder(root.right);
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }
    public static void main(String[] args) {
    	TreeNode bintree=new TreeNode();
        Object []a={3,5,1,6,2,0,8,null,null,7,4};
        bintree.creat(a);
        getNodeP(bintree.root,5);
        getNodeQ(bintree.root,2);
        System.out.println(lowestCommonAncestor(bintree.root, p ,q).val);
    }

}
