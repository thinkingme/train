package cn.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 * 508. 出现次数最多的子树元素和
 * </p>
 *
 * @author: huige
 * @date: 2022/6/19 10:05
 */
public class _508出现次数最多的子树元素和 {

    static int max = -1;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFrequentTreeSum(TreeNode.buildTree(new Integer[]{5, 2, -3}))));
    }
    public static int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root,map);
        map.forEach((a,b)->{
            if(b == max) {
                res.add(a);
            }
        });
        return res.stream().mapToInt(e->e).toArray();
    }

    private static int dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null){
            return 0;
        }

        int curRootResult = dfs(root.left,map) + dfs(root.right,map);
        curRootResult+=root.val;
        map.put(curRootResult,map.getOrDefault(curRootResult,0)+1);
        max = Math.max(map.get(curRootResult),max);
        return curRootResult;
    }
}
