package com.queue.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.queue.entity.WebSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liusong on 2018/4/18.
 * 客服集合
 */
@ServerEndpoint("/ws/socket/service/{username}")
public class CustomServiceSocket {

    private Logger log = LogManager.getLogger(CustomServiceSocket.class);

    //客服人员在线集合
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    //客服在线人数
    private static Integer onlineClient = 0;

    @OnOpen
    public void open(@PathParam("username") String username, Session session){
        if(checkOnline(username)){
            clients.put(username, new WebSocket(username, session));
            addOnlineClient();
            JSONObject result = new JSONObject();
            result.put("msg", "目前客户在线人数" + ConversationSocket.getOnlineCount());
            sendMessageTo(username, result.toJSONString());

            result.put("msg", "目前客服在线人数" + getOnlineClient());
            ConversationSocket.sendMessageAll(result.toJSONString());
            log.info("客服人员："+username+"上线了");
        }else{
            log.info("客服人员："+username+"已经在线了");
        }
    }

    /**
     *
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
            ChatRoomSocket.close(token);
            result.put("msg","对话链接已关闭");
            serSocket.sendMessage(result.toJSONString());
        }else if("S".equals(conn)){
            WebSocket socket = ChatRoomSocket.getClient(token, 1);
            if(socket == null){
                result.put("msg","链接已断开或应答码错误");
                serSocket.sendMessage(result.toJSONString());
            }else{
                result.put("msg", msg);
                socket.sendMessage(result.toJSONString());
            }
        }else{
            result.put("msg","-1");
            serSocket.sendMessage(result.toJSONString());
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
                    clients.remove(socket);
                    removeOnlineClient();
                }
            }
        }
        return null;
    }
}
