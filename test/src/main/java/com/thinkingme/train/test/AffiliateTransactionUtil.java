package com.thinkingme.train.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/10/21 15:52
 */
public class AffiliateTransactionUtil {
    private static HttpClient httpClient = new DefaultHttpClient();

    /**
     * 以post方式调用第三方接口
     * @param url
     * @param json
     * @return
     */
    public static JSONObject doPost(String url,Integer timeOut, JSONObject json){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",-1);
        jsonObject.put("msg","请求异常！");
        HttpResponse response = null;
        try {
            HttpPost post = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).build();
            post.setConfig(requestConfig);
            StringEntity s = new StringEntity(json.toString());
            s.setContentEncoding("UTF-8");
            //发送json数据需要设置contentType
            s.setContentType("application/x-www-form-urlencoded");
            //设置请求参数
            post.setEntity(s);
            response = httpClient.execute(post);
            String string = EntityUtils.toString(response.getEntity());
            return JSONObject.parseObject(string);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return jsonObject;
    }
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("","");
        System.out.println(doPost("https://wechat-test.iconntech.com/hzTrustApiGateway/affiliateTransaction/apply",60000,jsonObject));
    }
}
