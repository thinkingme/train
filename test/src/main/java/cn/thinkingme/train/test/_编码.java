package cn.thinkingme.train.test;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/5/13 21:35
 */
public class _编码 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(getEncoding("中·国"));
        String[][] deepArray = new String[][] {{"沉默", "王二"}, {"一枚有趣的程序员"}};
        System.out.println("系统默认编码：\u4E2D\u9655\u56fd\u6295\u00b7\u957f\u79e6\u0032\u0036\u53f7\u897f\u54b8\u5929\u6c49\u96c6\u5408\u8d44\u91d1\u4fe1\u6258\u8ba1\u5212\ue111" + System.getProperty("file.encoding"));
        String str = new String("Aa帅锅");
        byte[] b1 = "爱新觉罗·我爱罗".getBytes("GB2312");
        String Str = new String(b1, "GB2312");
        System.out.println(Str);
    }
    //判断字符串编码
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }
}
