package cn.thinkingme.train.shua.LeetCode;

/**
 * <p>
 * 句子中的有效单词数
 * </p>
 *
 * @author: huige
 * @date: 2022/1/27 10:36
 */
public class _2047句子中的有效单词数 {
    public static void main(String[] args) {
        System.out.println(countValidWords(" o6 t"));
    }
    public static int countValidWords(String sentence) {
        int res = 0;
        String reg = "[a-z]*([a-z]-[a-z])?[a-z]*[!.,]?";
        for (String s : sentence.split("\\s\\s*")) {
            if(s.length()>0 && s.matches(reg)){
                res++;
            }
        }
        return res;
    }

}
