package com.thinkingme.train.test.aes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * 统一的加解密方法，采用AES，原本的DES不要用了
 */

public class ListResultAES {

	//AES key
	public final static String AES_KEY = "apexsoft_#$%_xmxt";
	//前缀
	public final static String AES_PRE = "";
    /**
     * 加密一些特定的出参
     * @param fromList json 数组
     * @param fieldArray 需要加密的字段
     * @return
     */
    public static JSONArray ListResultEnc(JSONArray fromList,String[] fieldArray) throws Exception {
    	JSONArray originList=fromList;
    	//获取加密方式，
    	  for (String field : fieldArray) {
              originList= ListResultEncString(originList,field);
          }
    	return originList;
    }

    /**
     * 单个解析
     * @param fromList
     * @param field
     * @return
     */
    public static JSONArray ListResultEncString(JSONArray fromList,
    		String field) throws Exception {
    	JSONArray resultJSONArray=new JSONArray();
              for(int i=0;i<fromList.size();i++) {
            	  JSONObject jo=fromList.getJSONObject(i);
            	  String sourceString = jo.getString(field);
            	  String encString  = AESUtil.encrypt(AES_PRE+sourceString,AES_KEY);
            	  jo.put(field, encString);
            	  resultJSONArray.add(jo);
              }
    	return resultJSONArray;
    }


	/**
	 * 加密一些特定的出参
	 * @param jsonStr json串
	 * @param fieldArray 需要加密的字段
	 * @return
	 */
	public static String resultEnc(String jsonStr,String[] fieldArray) throws Exception {
		String res = jsonStr;
		//获取加密方式，
		for (String field : fieldArray) {
			res= resultEnc(res,field);
		}
		return res;
	}

	/**
	 * 单个解析
	 * @param str json串
	 * @param field 需要加密的字段
	 * @return
	 */
	public static String resultEnc(String str,String field) throws Exception {
		JSONObject json = null;
		json = JSONObject.parseObject(str);
		Set<String> keySet = json.keySet();
		for(String key:keySet) {
			Object obj = json.get(key);
			if(obj instanceof JSONArray) {
				JSONArray arr = (JSONArray)obj;
				for(int i=0;i<arr.size();i++) {
					String child = resultEnc(arr.get(i).toString(),field);
					arr.set(i, JSONObject.parse(child));
				}
				json.put(key, arr);
			}else if(obj instanceof JSONObject){
				JSONObject sub = (JSONObject)obj;
				String substr = resultEnc(sub.toJSONString(),field);
				json.put(key, JSONObject.parse(substr));
			}else {
				if(key.equals(field)) {
					json.put(key, AESUtil.encrypt(AES_PRE+json.get(key),AES_KEY));
					System.out.println("update...");
				}
			}
		}
		return json.toJSONString();
	}


	/**
	 * 解密一些特定的出参
	 * @param jsonStr json串
	 * @param fieldArray 需要加密的字段
	 * @return
	 */
	public static String resultDec(String jsonStr,String[] fieldArray) throws Exception {
		String res = jsonStr;
		//获取加密方式，
		for (String field : fieldArray) {
			res= resultDec(res,field);
		}
		return res;
	}

	/**
	 * 单个解析
	 * @param str json串
	 * @param field 需要加密的字段
	 * @return
	 */
	public static String resultDec(String str,String field) throws Exception {
		JSONObject json = null;
		json = JSONObject.parseObject(str);
		Set<String> keySet = json.keySet();
		for(String key:keySet) {
			Object obj = json.get(key);
			if(obj instanceof JSONArray) {
				JSONArray arr = (JSONArray)obj;
				for(int i=0;i<arr.size();i++) {
					String child = resultDec(arr.get(i).toString(),field);
					arr.set(i, JSONObject.parse(child));
				}
				json.put(key, arr);
			}else if(obj instanceof JSONObject){
				JSONObject sub = (JSONObject)obj;
				String substr = resultDec(sub.toJSONString(),field);
				json.put(key, JSONObject.parse(substr));
			}else {
				if(key.equals(field)) {
					json.put(key, AESUtil.decrypt(AES_PRE+json.get(key),AES_KEY));
					System.out.println("update...");
				}
			}
		}
		return json.toJSONString();
	}



    /**
     * 加密单个字符串的方法
     * @param fromStr
     * @return
     */
    public static String StringResultEnc(String fromStr) throws Exception {
		return AESUtil.encrypt(AES_PRE+fromStr, AES_KEY);
    }
    /**
     * 解密单个字符串的方法
     * @param fromStr
     * @return
     */
    public static String StringResultDec(String fromStr) throws Exception {
    	String resultStr=AESUtil.decrypt(fromStr, AES_KEY);
		if(resultStr.indexOf(AES_PRE)==0) {
			resultStr=resultStr.substring(AES_PRE.length());
		}
		return resultStr;
   }
}
