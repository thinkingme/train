package cn.thinkingme.train.shua.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huige
 * @Description: 842. 将数组拆分成斐波那契序列
 * @Date: 2022/1/10 15:03
 */
public class SplitIntoFibonacci {
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("112358130"));
    }

    public static List<Integer> splitIntoFibonacci(String num) {
        int n = num.length();
        if (n < 3) {
            return new ArrayList<>();
        }
        for (int i = 0; i < n && i < 11; i++) {
            for (int j = i + 1; j < n && j < i + 11; j++) {
                if ((i > 0 && num.charAt(0) == '0') || (j > i + 1 && num.charAt(i + 1) == '0')){
                    continue;
                }
                long a = Long.parseLong(num.substring(0, i + 1));
                long b = Long.parseLong(num.substring(i + 1, j + 1));
                if (j + 1 >= n){
                    break;
                }
                ArrayList<Integer> longs = new ArrayList<>();
                longs.add((int) a);
                longs.add((int) b);
                if (dsf((int) a, (int) b, num, 0, j + 1, longs)) {
                    return longs;
                }
            }
        }
        return new ArrayList<>();
    }

    private static boolean dsf(Integer a, Integer b, String num, Integer cur, int index, ArrayList<Integer> longs) {
        Integer sum = cur * 10 + num.charAt(index) - '0';
        if (a + b == sum) {
            longs.add(sum);
            if (index == num.length() - 1) {
                return true;
            }
            return dsf(b, sum, num, 0, index + 1, longs);
        } else if (sum != 0 && sum < a + b && index < num.length() - 1) {
            return dsf(a, b, num, sum, index + 1, longs);
        } else {
            return false;
        }
    }
}
