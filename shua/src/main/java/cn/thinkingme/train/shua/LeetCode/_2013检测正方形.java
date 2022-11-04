package cn.thinkingme.train.shua.LeetCode;

import java.util.*;

/**
 * <p>
 * 对于 add 操作，我们可以使用「哈希表 套 哈希表」的方式，以 {x, {y : 点 (x,y) 数量}} 的形式对传入点进行存储。
 *
 * 对于 count 查询而言，假定传入的点为 (x, y)(x,y)，我们可以先查询 xx 行都有哪些列，枚举这些列（ 即枚举点 (x, ny)(x,ny) ），由 yy 和 nyny 可得正方形边长 lenlen，此时再检查唯一确定的两点 (x \pm len, y)(x±len,y) 和 (x \pm len, ny)(x±len,ny) 的出现次数，应用乘法原理，即可知道该正方形的方案数，统计所有合法方案数即是该询问的答案。
 *
 * 利用题目范围给定的 x 和 y 具有明确的范围 0 <= x, y <= 1000，我们可以使用数组充当哈希表，但是为了拓展性和减少边界判断，即支持将平面拓展到任意大小，最好还是直接使用哈希表。
 *
 *
 * 作者：AC_OIer
 * 链接：https://leetcode-cn.com/problems/detect-squares/solution/gong-shui-san-xie-jian-dan-ha-xi-biao-yu-748e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </p>
 *
 * @author: huige
 * @date: 2022/1/26 9:15
 */
public class _2013检测正方形 {
    class DetectSquares {
        Map<Integer, Map<Integer, Integer>> row2Col = new HashMap<>();

        public void add(int[] point) {
            int x = point[0], y = point[1];
            Map<Integer, Integer> col2Cnt = row2Col.getOrDefault(x, new HashMap<>());
            col2Cnt.put(y, col2Cnt.getOrDefault(y, 0) + 1);
            row2Col.put(x, col2Cnt);
        }

        public int count(int[] point) {
            int x = point[0], y = point[1];
            int ans = 0;
            Map<Integer, Integer> col2Cnt = row2Col.getOrDefault(x, new HashMap<>());
            for (int ny : col2Cnt.keySet()) {
                if (ny == y) continue;
                int c1 = col2Cnt.get(ny);
                int len = y - ny;
                int[] nums = new int[]{x + len, x - len};
                for (int nx : nums) {
                    Map<Integer, Integer> temp = row2Col.getOrDefault(nx, new HashMap<>());
                    int c2 = temp.getOrDefault(y, 0), c3 = temp.getOrDefault(ny, 0);
                    ans += c1 * c2 * c3;
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {


    }

}
