package cn.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 165. 比较版本号
 * </p>
 *
 * @author: huige
 * @date: 2022/3/28 22:58
 */
public class _165比较版本号 {

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01","1.01.0"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\."), ss2 = version2.split("\\.");
        int n = ss1.length, m = ss2.length;
        int i = 0, j = 0;
        while (i < n || j < m) {
            int a = 0, b = 0;
            if (i < n){
                a = Integer.parseInt(ss1[i++]);
            }
            if (j < m){
                b = Integer.parseInt(ss2[j++]);
            }
            if (a != b){
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }
}
