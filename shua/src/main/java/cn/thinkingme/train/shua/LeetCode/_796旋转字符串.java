package cn.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 796. 旋转字符串
 * </p>
 *
 * @author: huige
 * @date: 2022/4/7 9:29
 */
public class _796旋转字符串 {
    public boolean rotateString(String s, String goal) {
        String.class.getClassLoader();
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
