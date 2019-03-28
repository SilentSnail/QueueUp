package com.queue.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by liusong on 2018/4/16.
 */
public class IMUtils {

    //URL列表
    private static Map<String,String> urls;

    /**
     * 读取URL配置文件
     */
    static {
        urls = new HashMap<String, String>();
        InputStream in = null;
        Properties properties;
        try {
            properties = new Properties();
            in = PropertiesUtil.class.getResourceAsStream("/imUrlConfig.properties");
            properties.load(in);
            for (Object k :properties.keySet()) {
                String key = k.toString();
                urls.put(key.toString(), properties.get(key.toString()).toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(null != in){
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static List<NameValuePair> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        list.add(new BasicNameValuePair("from","admin"));
        list.add(new BasicNameValuePair("to","account"));
        list.add(new BasicNameValuePair("ope", "0"));
        list.add(new BasicNameValuePair("type", "0"));
        JSONObject json = new JSONObject();
        json.put("msg", "我想预定一间大床房");
        list.add(new BasicNameValuePair("body", json.toJSONString()));
        String res = sendMessage(list);
        System.out.println(res);
    }

    /**
     * 创建用户
     * @param account 账号
     * @param name 用户名
     * @return 账号信息
     */
    public static Map<String,Object> create(String account, String name){
        Map<String,Object> result = null;
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("accid", account));
        list.add(new BasicNameValuePair("mobile", name));
        try {
            Map map = HttpUtils.postAccessUrl(urls.get("createUrl"), list);
            Integer code = Integer.parseInt(map.get("code").toString());
            if (code == 200){//操作成功
                String res = map.get("info").toString();
                System.out.println(res);
            }else{
                System.out.println(code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新账号token
     * @param account 账号
     * @return 成功返回token 错误返回失败信息
     */
    public static String refreshToken(String account){
        list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("accid",account));
        try {
            Map result = HttpUtils.postAccessUrl(urls.get("refreshToken"), list);
            Integer code = Integer.parseInt(result.get("code").toString());
            if (code == 200){//操作成功
                String res = result.get("info").toString();
                return (JSONObject.parseObject(res, HashMap.class)).get("token").toString();
            }else{
                System.out.println(code);
                return result.get("desc").toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 发送消息
     * @param list 消息参数列表
     * @return SUCCESS表示成功，其他表示失败
     */
    public static String sendMessage(List<NameValuePair> list){
        try {
            Map map = HttpUtils.postAccessUrl(urls.get("sendMessage"), list);
            Integer code = Integer.parseInt(map.get("code").toString());
            if(code == 200){//成功
                System.out.println("发送成功");
                return "SUCCESS";
            }else{//失败
                System.out.println(code);
                return map.get("desc").toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
