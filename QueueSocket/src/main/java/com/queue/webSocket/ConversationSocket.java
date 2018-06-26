package com.queue.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.queue.entity.WebSocket;
import com.queue.util.CheckSumBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户Socket
 * Created by liusong on 2018/4/17.
 */
@ServerEndpoint("/ws/socket/custom/{username}")
public class ConversationSocket {

    private Logger log = LogManager.getLogger(ConversationSocket.class);

    //用户在线集合
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();

    //在线人数
    private static int onLineCount = 0;

    /**
     * 开启Socket链接
     * @param username
     * @param session
     */
    @OnOpen
    public void open(@PathParam("username") String username, Session session){
        if(checkOnline(username)){
            JSONObject json = new JSONObject();
            String token = CheckSumBuilder.getMD5(username + UUID.randomUUID().toString());
            WebSocket socket = new WebSocket(username, session);
            socket.setToken(token);
            clients.put(username, socket);
            addOnlineCount();
            json.put("token", token);
            json.put("msg", "目前客服在线人数：" + CustomServiceSocket.getOnlineClient());
            socket.sendMessage(json.toJSONString());
            log.info(username+"上线了");
        }else{
            log.info(username+ "已在线上");
        }
    }

    /**
     * 关闭链接
     * @param username 谁关闭了链接
     */
    @OnClose
    public void close(@PathParam("username") String username){
        if(checkOnline(username) == false){
            ChatRoomSocket.close(clients.get(username).getToken());
            clients.remove(username);
            removeOnlineCount();
            log.info(username+"下线了");
        }
    }

    /**
     * 出现错误了，执行到该方法的时候，会踢出在线的Session
     * @param username 当前的用户名
     * @param error
     */
    @OnError
    public void error(@PathParam("username") String username, Throwable error){
        if(error instanceof NullPointerException){
            log.info("空指针，预计发送消息的时候没有找到发送的对象。");
        }
        log.info("由于系统错误，"+username+"被系统踢下线了");
        error.printStackTrace();
    }

    /**
     * 发送消息
     * @param username 消息发送人
     * @param message {"msg":"", "token":"","conn":""}发送的消息
     */
    @OnMessage
    public void sendMessage(@PathParam("username") String username, String message){
        WebSocket curSocket = clients.get(username);
        JSONObject result = new JSONObject();
        try {
            JSONObject json = JSONObject.parseObject(message);
            String token = json.getString("token");
            String msg = json.getString("msg");
            if("Y".equals(json.getString("conn"))){//开启链接
                ChatRoomSocket.open(token, curSocket);
                result.put("msg","对话链接已开启");
                curSocket.sendMessage(result.toJSONString());
            }else if("N".equals(json.getString("conn"))){//关闭链接
                ChatRoomSocket.close(token);
                result.put("msg","对话链接已关闭");
                curSocket.sendMessage(result.toJSONString());
            }else if("S".equals(json.getString("conn"))){//发送消息
                WebSocket socket = ChatRoomSocket.getClient(token, 0);
                if(socket != null){
                    result.put("msg", msg);
                    socket.sendMessage(result.toJSONString());
                }else{
                    result.put("msg","会话已断开或应答码错误");
                    curSocket.sendMessage(result.toJSONString());
                }
            }else{
                result.put("msg","-1");
                curSocket.sendMessage(result.toJSONString());
            }
        } catch (Exception e) {
            result.put("msg", "系统消息：格式或消息内容错误。");
            curSocket.sendMessage(result.toJSONString());
        }
    }

    /**
     * 向单人发送数据
     * @param token 收消息的token
     * @param message 发送的消息文本
     * getBasicRemote 同步; getAsyncRemote 异步
     * 这里使用异步发送消息
     */
    public static void sendMessageTo(String token, String message){
        clients.get(token).sendMessage(message);
    }

    /**
     * 向所有在线的人发送消息
     * @param message 发送的消息
     * 该功能由系统使用，不建议单个用户使用
     */
    public static void sendMessageAll(String message){
        for (WebSocket socket: clients.values()) {
            socket.sendMessage(message);
        }
    }

    //在线人数增加
    private static synchronized void addOnlineCount(){
        onLineCount += 1;
    }

    //在线人数减少
    private static synchronized void removeOnlineCount(){
        onLineCount -= 1;
    }

    //获取当前在线人数
    public static synchronized Integer getOnlineCount(){
        return onLineCount;
    }

    /**
     * 依据token获取链接
     * @param token
     * @return
     */
    public static synchronized WebSocket getClient(String token){
        for (WebSocket socket : clients.values()) {
            if(token.equals(socket.getToken()))
                return socket;
        }
        return null;
    }

    /**
     * 判断是否在线
     * @param username 用户名
     * @return 不在线返回true 在线返回false
     */
    public static synchronized boolean checkOnline(String username){
        return clients.get(username) == null ? true : false;
    }
}
