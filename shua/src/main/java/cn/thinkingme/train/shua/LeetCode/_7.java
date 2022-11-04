package cn.thinkingme.train.shua.LeetCode;


public class _7 {

    public int reverse(int x) {
        int res = 0;
        int last = 0;
        while(x!=0) {
            int tmp = x % 10;
            res = res * 10 + tmp;
            last = res;
            if (last != res / 10) {
                return 0;
            }
            x /= 10;
        }
        return res;

    }
}
