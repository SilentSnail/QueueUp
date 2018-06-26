package com.queue.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liusong on 2018/4/16.
 */
public class HttpUtils {

    private static final String appKey = "6d20855701be01801c7ee7bbca30f8cb";
    private static final String appSecret = "14922d19ac5c";
    private static final String nonce = "I'm Love it";
    private static final String encoding = "utf-8";
    private static final String contentType = "application/x-www-form-urlencoded;charset=utf-8";

    /**
     * 访问URL返回数据
     * @param url 访问的URL
     * @param list 参数列表
     * @return 访问URL的result
     * @throws IOException
     */
    public static Map postAccessUrl(String url, List<NameValuePair> list) throws IOException {
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        HttpPost post = new HttpPost(url);
        post.setHeader("AppKey", appKey);
        post.setHeader("Nonce", nonce);
        post.setHeader("CurTime", curTime);
        post.setHeader("CheckSum", checkSum);
        post.setHeader("Content-Type", contentType);
        post.setEntity(new UrlEncodedFormEntity(list, encoding));

        CloseableHttpClient client = HttpClients.createDefault();

        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(), encoding);
        System.out.println(result);
        Map map = JSONObject.parseObject(result, HashMap.class);
        return map;
    }
}
