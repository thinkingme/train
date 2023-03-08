package com.thinkingme.train.shua.LeetCode;

/**
 * @ProjectName: 题目代码
 * @Package: LeetCode
 * @ClassName: 剑指Offer43
 * @Author: huige
 * @Description: 1～n 整数中 1 出现的次数
 * 将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数。
 *
 * 三种情况，都可以由cur=0演化而来。
 * 1、当cur=0时，以23045为例子，求百位位置上出现1的次数。此时可选范围是00100---22199，high有23种排列组合，low有100种排列组合，
 * 所以百位位置上出现1的次数总数为：23*100-->即high*digit;
 * 2、当cur=1时，以23145为例子，求百位上出现1的次数。此时可以把0~23145拆分成两项：0~23045以及23046~23145。那么0~23045可以由第一种情况得出结果：high*digit=23*100。剩下的工作就是求23046~23145中百位出现1的次数，显然只有23100~23145才满足要求，所以第二项的结果就是low+1=45+1。总的公式为high*digit+low+1；
 * 3、当cur>1时，以23345为例子，求百位上出现1的次数，此时可以把0~23345拆分成0~23199以及23200~23345。第二项23200~23345显然没有满足要求的数字。
 * 那么求0~23199中百位出现1次数可以由第二种情况得出：high*digit+low+1=23*100+99+1。
 * 由于cur是>1的，所以所求的数字（23345）向下取到 满足要求的最大数字（23199）时，low位数字必然是99，而0~99个数正好是digit（100=99+1）。
 * 所以可以把22345转化为22199，此时公式为high*digit+low+1 = high*digit+digit=（high+1）*digit。
 * 由此看出，cur=1可以由cur=0演变过来，cur>1可以由cur=1演变过来
 * @Date: 2021/8/13 9:35
 * @Version: 1.0
 */
public class 剑指Offer43 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(9));
    }
    public static  int countDigitOne(int n) {
        int high = n / 10, low = 0, cur = n % 10, digit = 1;
        int res = 0;
        while (high!= 0 || cur != 0) {
            switch (cur) {
                case 0:
                    res += high * digit;
                    break;
                case 1:
                    res += high * digit + low + 1;
                    break;
                default:
                    res+=(high + 1) * digit;
                    break;
            }
            low = low + cur*digit;
            cur = high%10;
            high = high/10;
            digit*=10;
        }
        return res;
    }
}














