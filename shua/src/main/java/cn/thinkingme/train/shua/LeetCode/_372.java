package cn.thinkingme.train.shua.LeetCode;

import java.util.Stack;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: _372
 * @Author: huige
 * @Description: 超级次方
 * @Date: 2021/8/19 14:34
 * @Version: 1.0
 */
public class _372 {
    int mod = 1337;

    public int superPow(int a, int[] b) {
        if(a == 1) return a;
        int m = b.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < m; i++) {
            st.push(b[i]);
        }
        return superPow(a, st);
    }

    public int superPow(int a, Stack<Integer> st) {
        if(st.isEmpty()) return 1;
        int last = st.pop();
        int part1 = fastPowerDFS(a, last) % mod;
        int part2 = superPow(a, st);
        part2 = fastPowerDFS(part2, 10) % mod;
        return (part1 * part2) % mod; // 结果可能超限，所以需要求余之后再返回；
    }

    public int fastPowerDFS(int base, int power) {
        if(power == 0)return 1;
        base%=mod;
        if(power%2 == 1){
            return (base * fastPowerDFS(base,power-1))%mod;
        }else{
            int sub = fastPowerDFS(base,power>>1);
            return (sub * sub)%mod;
        }
    }
}
