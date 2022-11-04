package cn.thinkingme.train.shua.LeetCode;

import java.util.HashMap;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _447
 * @Author: huige
 * @Description: 回旋镖的数量
 * @Date: 2021/9/13 9:41
 * @Version: 1.0
 */
public class _447 {
    
    /**
     * @Method 
     * @Author linzhenhui
     * @Version  1.0
     * @DescriptionJAVA 实现： 这道题思路其实也比较简单，计算一点和其他点之间的距离，使用哈希表存储，若同一距离出现多次，则可以形成回旋镖。
     * 假设同一距离出现 n 次，由数字规律可推出回旋镖的数量 sum = n*(n-1) 。本人开始只能做到存储到哈希表，然后按该公式累加得到最后结果。
     * 参考了速度第一的答案，优化如下：假设当前同一距离的数量为 n, 回旋镖数量为 n*(n-1), 当再出现一个同一距离时，回旋镖的数量应为 (n+1)*n，
     * 与之前相差 (n+1)*n - n*(n-1) = 2*n， 所以只需要把最后答案加上 2*n, 最后 n+1 再存储到哈希表中
     * @Param 
     * @Return 
     * @Exception 
     * @Date 2021/9/13 
     */
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int ans = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i != j){
                    double dis = Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2);
                    if(!map.containsKey(dis)){
                        map.put(dis, 1);
                    }else{
                        int n = map.get(dis);
                        ans += 2 * n;
                        map.put(dis, 1+n);
                    }
                }
            }
            map.clear();
        }
        return ans;
    }
}
