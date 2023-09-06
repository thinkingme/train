package com.thinkingme.train.test.aes;

import java.util.HashMap;

/**
 * <p>
 *  遍历hashmap
 * </p>
 *
 * @author: huige
 * @date: 2022/10/11 10:58
 */
public class Hs {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> hs = new HashMap<String, Object>(){{
            put("id","5654");
            put("B","xxxx");
        }};
        String str = "{\"id\":101,\"name\":\"buejee\",\"children\":[{\"id\":1101,\"name\":\"buejee1\"},{\"id\":1102,\"name\":\"buejee2\"}],\"sub\":{\"id\":1011,\"name\":\"buejee11\"}}";
        System.out.println(str);
        String enc = ListResultAES.resultEnc(str, new String[]{"id"});
        System.out.println(enc);
        String dec = ListResultAES.resultDec(enc, new String[]{"id"});
        System.out.println(dec);

    }

}
