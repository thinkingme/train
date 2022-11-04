package cn.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 513. 找树左下角的值
 * </p>
 *
 * @author: huige
 * @date: 2022/6/22 11:02
 */
public class _513找树左下角的值 {

    static int maxLevel = -1;
    static int num = 0;

    public static void main(String[] args) {
        // \u000d System.out.println("coder Hydra");
        System.out.println(findBottomLeftValue(TreeNode.buildTree(new Integer[]{1,2,3,4,null,5,6,null,null,7})));
    }
    public static int findBottomLeftValue(TreeNode root) {
        dfs(root,1);
        return num;
    }

    private static void dfs(TreeNode root, int level) {
        if(root == null){
            return;
        }
        if(level>maxLevel){
            num = root.val;
            maxLevel = level;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
