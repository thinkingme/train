package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _51N皇后
 * https://leetcode-cn.com/problems/n-queens/solution/hui-su-fa-java-by-ji-yi-zx-btt7/
 * 这道题主要是要考虑如何来表示四个约束条件：
 * 1.每行只有一个
 * 2.每列只有一个
 * 3.每45°斜线只有一个
 * 4.每135°斜线只有一个
 *
 * 约束条件可以考虑适用哈希表或者布尔数组来表示，我这里选择使用了布尔数组。
 *
 * 对于1.每行只有一个，我们可以在遍历的时候就以行为单元来遍历，即将每一行看成一个整体，比如N=4时，每一行就只有4种可能即{"Q....",".Q..","..Q.","...Q"}，我们直接对这4种可能作遍历，就不需要做对行列的二维遍历了
 * 对于2.每列只有一个，使用isColValid布尔数组来表示，长度为n
 * 对于3.每45°角只有一个，使用isDiagonalValid布尔数组表示，长度为2*n-1,这里唯一要说明一下的是下标的映射，看下图，以N=4为例：
 *
 * 每一种颜色表示一个45°斜对角线，观察每一种颜色的坐标的规律，这种映射的规律应该很多，其中一种比较好找的规律就是对于坐标(x,y)，loc = y - x,就可以得到对应图中无颜色区域的数字，但是可以看到得到的数字范围是-3~3，所以可以同时都+3，映射到正整数域，公式即为y-x+size-1
 * 对于4.每135°角只有一个，使用isReverseDiagonalValid布尔数组表示，长度为2*n-1,和上面累死找规律：
 *
 * 这个就比较明显了，对于坐标(x,y),loc = x + y,并且映射的值域>=0。
 * 其余就是回溯法的经典代码了，不多做赘述。
 *
 * 作者：ji-yi-zx
 * 链接：https://leetcode-cn.com/problems/n-queens/solution/hui-su-fa-java-by-ji-yi-zx-btt7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author: huige
 * @Description: 回溯
 * @Date: 2021/11/29 13:08
 * @Version: 1.0
 */
public class _51N皇后 {
    class Solution {
        Solution(){
            tmp = new LinkedList<String>();
            ans = new LinkedList<List<String>>();
        };
        private boolean[] isColValid; //每一列是否合法
        private boolean[] isDiagonalValid; // 正对角是否合法(45°)
        private boolean[] isReverseDiagonalValid; // 反对角是否合法(135°)
        private char[] chArr; // 每行的字符数组
        private List<String> tmp; // 暂时存储符合条件的情况
        private List<List<String>> ans; // 答案
        private int size; // N皇后的大小
        private void solve(int n){
            if(n==size){
                ans.add(new LinkedList<>(tmp));
                return;
            }
            for(int i = 0; i < size ; i++){
                int diagonalLoc = i-n+size-1;
                int reverseDiagonalLoc = i + n;
                if(isColValid[i]==false && isDiagonalValid[diagonalLoc]==false && isReverseDiagonalValid[reverseDiagonalLoc]==false){
                    chArr[i] = 'Q';
                    tmp.add(new String(chArr));
                    chArr[i] = '.';
                    isColValid[i] = true;
                    isDiagonalValid[diagonalLoc] = true;
                    isReverseDiagonalValid[reverseDiagonalLoc] = true;

                    solve(n+1);

                    tmp.remove(tmp.size()-1);
                    isColValid[i] = false;
                    isDiagonalValid[diagonalLoc] = false;
                    isReverseDiagonalValid[reverseDiagonalLoc] = false;
                }
            }
        };
        public List<List<String>> solveNQueens(int n) {
            // 初始化
            isColValid = new boolean[n];
            chArr = new char[n];
            Arrays.fill(chArr,'.');
            isDiagonalValid = new boolean[2*n-1];
            isReverseDiagonalValid = new boolean[2*n-1];
            size = n;

            solve(0);

            return ans;
        }
    }

}
