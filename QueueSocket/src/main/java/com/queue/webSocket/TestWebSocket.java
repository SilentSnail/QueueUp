package com.queue.webSocket;

import com.queue.entity.WebSocket;
import net.sf.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liusong on 2018/4/17.
 */
@ServerEndpoint("/ws/websocket/{username}")
public class TestWebSocket {

    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();//链接
    private static int onlineCount = 0;//在线人数

    @OnOpen
    public void open(@PathParam("username") String username, Session session){
        if(checkOnline(username)){
            addOnlineCount();
            clients.put(username, new WebSocket(username, session));
            System.out.println(username + ":上线了");
            sendMessageTo("目前在线人数：" + getOnlineCount() , username);
        }else{
            System.out.println(username + ":已是在线状态");
        }
    }

    private boolean checkOnline(String username){
        WebSocket obj = clients.get(username);
        if(obj == null){
            return true;
        }
        return false;
    }

    @OnClose
    public void close(@PathParam("username") String username){
        clients.remove(username);
        System.out.println(username + "下线了");
        removeOnlineCount();
    }

    @OnMessage
    public void sendMessage(@PathParam("username") String from, String message){
        JSONObject json = JSONObject.fromObject(message);
        String msg = from + "：" + json.get("message").toString();
        if(json.get("type").equals("to")){
            String to = json.get("username").toString();
            if(checkOnline(to)){
                to = from;
                msg = "系统消息：消息目标不在线上";
            }
            if(from.equals(to)){
                to = from;
                msg = "系统消息：不允许给自己发消息";
            }
            sendMessageTo(msg, to);
        }else if(json.get("type").equals("all")){
            sendMessageAll(msg);
        }else{
            new Exception("参数异常");
        }
    }

    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
    }

    //getAsyncRemote异步发送消息  getBasicRemote 同步发送消息
    //向某一对象发送消息 这里使用异步发送消息
    public void sendMessageTo(String message, String to){
        clients.get(to).getSession().getAsyncRemote().sendText(message);
    }

    //向所有在线的人发送消息
    public void sendMessageAll(String message){
        for (WebSocket socket: clients.values()) {
            socket.getSession().getAsyncRemote().sendText(message);
        }
    }

    private static synchronized void addOnlineCount(){
        onlineCount++;
    }

    private static synchronized void removeOnlineCount(){
        onlineCount--;
    }

    private static synchronized int getOnlineCount(){
        return onlineCount;
    }

    private static synchronized Map<String, WebSocket> getClients(){
        return clients;
    }
}
