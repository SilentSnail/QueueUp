package com.queue.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.queue.entity.WebSocket;
import com.queue.utils.CheckSumBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liusong on 2018/4/18.
 * 客服集合
 */
@ServerEndpoint("/ws/socket/service/{username}")
public class ServiceSocket {

    private Logger log = LogManager.getLogger(ServiceSocket.class);

    //客服人员在线集合
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    //客服在线人数
    private static Integer onlineClient = 0;

    @OnOpen
    public void open(@PathParam("username") String username, Session session){
        if(checkOnline(username)){
            WebSocket socket = new WebSocket(username, session);
            String token = CheckSumBuilder.getMD5(username + UUID.randomUUID().toString());
            socket.setToken(token);
            clients.put(username, socket);
            addOnlineClient();
            JSONObject result = new JSONObject();
            result.put("token", token);
            result.put("msg", "目前客户在线人数：" + ClientSocket.getOnlineCount());
            sendMessageTo(username, result.toJSONString());
            result.put("msg", "目前客服在线人数：" + getOnlineClient());
            ClientSocket.sendMessageAll(result.toJSONString());
            log.info("客服人员："+username+"上线了");
        }else{
            log.info("客服人员："+username+"已经在线了");
        }
    }

    /**
     * 发送消息
     * @param username
     * @param message {"msg":"", "token":"", "conn":""}
     */
    @OnMessage
    public void sendMessage(@PathParam("username") String username, String message){
        WebSocket serSocket = clients.get(username);
        JSONObject result = new JSONObject();
        JSONObject json = JSONObject.parseObject(message);
        String msg = json.getString("msg");
        String token = json.getString("token");
        String conn = json.getString("conn");
        if("N".equals(conn)){
            result.put("msg","对话链接已关闭");
            serSocket.setStatus(0);
            if(ChatRoomSocket.checkConnection(serSocket.getToken())){
                ChatRoomSocket.sendMessageTo(result.toJSONString(), serSocket.getRoomToken(), ChatRoomSocket.CLIENT);
                ChatRoomSocket.sendMessageTo(result.toJSONString(), serSocket.getRoomToken(), ChatRoomSocket.SERVER);
                ChatRoomSocket.close(serSocket.getRoomToken());
            } else {
                serSocket.sendMessage(result.toJSONString());
            }

        } else if("S".equals(conn)){
            WebSocket socket = ChatRoomSocket.getClient(token, ChatRoomSocket.CLIENT);
            if(socket == null){
                result.put("msg","链接已断开或应答码错误");
                serSocket.sendMessage(result.toJSONString());
            } else {
                result.put("msg", msg);
                socket.sendMessage(result.toJSONString());
            }
        } else {
            result.put("msg","-1");
            serSocket.sendMessage(result.toJSONString());
        }
    }

    /**
     * 服务端群发消息
     * @param msg
     */
    public static void sendAllMessage(String msg){
        for (String key : clients.keySet()) {
            WebSocket socket = clients.get(key);
            JSONObject json = new JSONObject();
            json.put("msg", msg);
            socket.sendMessage(json.toJSONString());
        }
    }

    @OnError
    public void error(Throwable error){
        log.error(error);
    }

    @OnClose
    public void close(@PathParam("username") String username){
        if(checkOnline(username)){
            ChatRoomSocket.closeService(username);
            clients.remove(username);
            removeOnlineClient();
            log.info(username+"下线了");
        }
    }

    public static synchronized boolean checkOnline(String username){
        return clients.get(username) == null ? true : false;
    }

    public static void sendMessageTo(String to, String message){
        clients.get(to).sendMessage(message);
    }

    private static synchronized void addOnlineClient(){
        onlineClient += 1;
    }

    private static synchronized void removeOnlineClient(){
        onlineClient -= 1;
    }

    public static synchronized Integer getOnlineClient(){
        return onlineClient;
    }

    public static synchronized WebSocket getClient(){
        for (WebSocket socket : clients.values()) {
            if(socket.getStatus() == 0){//如果客服人员空闲，则设置该客服人员状态为繁忙，并返回该客服信息
                if(socket.getSession().isOpen()){
                    socket.setStatus(1);
                    return socket;
                }else{
                    clients.remove(socket.getUserName());
                    removeOnlineClient();
                }
            }
        }
        return null;
    }
}
