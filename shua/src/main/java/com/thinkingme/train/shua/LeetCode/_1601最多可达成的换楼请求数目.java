package com.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 1601. 最多可达成的换楼请求数目
 * 枚举所有可能，使用二进制状态压缩，位1的视为请求通过
 * </p>
 *
 * @author: huige
 * @date: 2022/2/28 13:58
 */
public class _1601最多可达成的换楼请求数目 {
    public static void main(String[] args) {

    }
    int[][] rs;
    public int maximumRequests(int n, int[][] requests) {
        rs = requests;
        int m = rs.length, ans = 0;
        for (int i = 0; i < (1 << m); i++) {
            //位1的个数就是允许的请求数
            int cnt = getCnt(i);
            //找最大值
            if (cnt <= ans) continue;
            if (check(i)) ans = cnt;
        }
        return ans;
    }
    boolean check(int s) {
        int[] cnt = new int[20];
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            //当位数是1时表示允许此次请求，因此可以计算
            if (((s >> i) & 1) == 1) {
                int a = rs[i][0], b = rs[i][1];
                //
                if (++cnt[a] == 1) sum++;
                if (--cnt[b] == 0) sum--;
            }
        }
        //没有变化的话，返回正确
        return sum == 0;
    }
    int getCnt(int s) {
        int ans = 0;
        //计算位1的个数
        for (int i = s; i > 0; i -= (i & -i)) ans++;
        return ans;
    }
}
