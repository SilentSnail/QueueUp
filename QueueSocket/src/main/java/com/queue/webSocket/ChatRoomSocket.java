package com.queue.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.queue.entity.SocketSession;
import com.queue.entity.WebSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 客服聊天集合
 * Created by liusong on 2018/4/18.
 */
public class ChatRoomSocket {

    private static Logger log = LogManager.getLogger(ChatRoomSocket.class);
    //对话
    private static Map<String, SocketSession> sessionMap = new ConcurrentHashMap<String, SocketSession>();

    public static void open(String token, WebSocket cusSocket){
        JSONObject json = new JSONObject();;
        if(checkConnection(token)){//未连接过
            WebSocket serSocket = CustomServiceSocket.getClient();//获取一个在线的客服人员
            if(serSocket == null){//如果没有有空闲的客服人员，向客户发送一条消息
                json.put("msg","目前坐席繁忙，请您稍后再试");
                ConversationSocket.sendMessageTo(token, json.toJSONString());
            }else{
                //消息发起人在线，且有空闲的客服人员
                SocketSession socket = new SocketSession(token);
                socket.setCusSocket(cusSocket);
                socket.setSerSocket(serSocket);
                sessionMap.put(token, socket);
                json = new JSONObject();
                json.put("custom", "客户"+cusSocket.getUserName()+"请求协助");
                json.put("service", "客服人员"+serSocket.getUserName()+"为您服务");
                json.put("token", token);
                cusSocket.sendMessage(json.toJSONString());
                serSocket.sendMessage(json.toJSONString());
            }
        }
    }

    /**
     * 获取链接
     * @param token 链接ID
     * @param curType 1：当前是客服  0：当前是客户
     * @return 对应的链接
     */
    public static WebSocket getClient(String token, Integer curType){
        SocketSession session = sessionMap.get(token);
        if(session == null){
            return null;
        }
        if(curType == 1){//代表当前是客服
            return session.getCusSocket();
        }else if(curType == 0){//单标当前是客户
            return session.getSerSocket();
        }else{
            return null;
        }
    }

    public static synchronized void close(String token){
        if(checkConnection(token) == false){
            sessionMap.get(token).getSerSocket().setStatus(0);
            sessionMap.get(token).getSerSocket().sendMessage("会话已关闭");
            sessionMap.get(token).getCusSocket().sendMessage("会话已关闭");
            sessionMap.remove(token);
        }
    }

    public static synchronized void closeService(String username){
        for(SocketSession session : sessionMap.values()){
            if(username.equals(session.getSerSocket().getUserName())){
                session.getSerSocket().sendMessage("会话已关闭");
                session.getCusSocket().sendMessage("会话已关闭");
                sessionMap.remove(session);
            }
        }
    }

    private static synchronized boolean checkConnection(String token){
        return sessionMap.get(token) == null ? true : false;
    }

}
