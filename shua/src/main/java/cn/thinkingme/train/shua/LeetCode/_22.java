package cn.thinkingme.train.shua.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _22
 * @Author: huige
 * @Description: 括号生成
 *
 * 别用排列组合，会造成很大的数超时 大小为（2n）！
 * 递归生成所有序列即可大小为 2^2n
 * @Date: 2021/8/3 17:22
 * @Version: 1.0
 */
public class _22 {

    public static void main(String[] args) {
        //System.out.println(generateParenthesis(3));
    }

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return null;

        def("", 0, 0, n);

        return res;
    }

    public void def(String paths, int left, int right, int n) {

        if (left > n || right > left) return;
        if (paths.length() == n * 2) {
            res.add(paths);
            return;
        }
        def(paths + "(", left + 1, right, n);
        def(paths + ")", left, right + 1, n);
    }
}
