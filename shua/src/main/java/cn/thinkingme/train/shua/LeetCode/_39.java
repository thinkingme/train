package cn.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _39
 * @Author: huige
 * @Description: 组合总和
 * @Date: 2021/9/17 10:00
 * @Version: 1.0
 */
public class _39 {
    static  Deque<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5},8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  outList = new ArrayList<>();
        dfs(candidates,target,outList,0);
        return outList;
    }
    public static void dfs(int[] candidates, int target,List<List<Integer>> outList,int cur){
        int sum = sumStack(list);
        if(sum>target){
            return;
        }
        if(sum == target){
            outList.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            list.addLast(candidates[i]);
            dfs(candidates, target, outList,i);
            list.removeLast();
        }
    }
    public static int sumStack(Deque<Integer> stack ){
        final int[] sum = {0};
        stack.forEach(son -> {
            sum[0]+=son;
        });
        return sum[0] ;
    }
    //更快的办法
    public List<List<Integer>> combinationSum_fast(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (target < 0) break;
            //System.out.println(start);
            tmp_list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }
}
