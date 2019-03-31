package com.queue.webSocket;

import com.queue.entity.SocketSession;
import com.queue.entity.WebSocket;
import com.queue.utils.CheckSumBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 客服聊天集合
 * Created by liusong on 2018/4/18.
 */
public class ChatRoomSocket {

    private static Logger log = LogManager.getLogger(ChatRoomSocket.class);
    //对话
    private static Map<String, SocketSession> sessionMap = new ConcurrentHashMap<String, SocketSession>();

    public static final int CLIENT = 1;
    public static final int SERVER = 0;

    public static boolean open(WebSocket cusSocket){
        if(checkConnection(cusSocket.getToken())){//未连接过
            WebSocket serSocket = ServiceSocket.getClient();//获取一个在线的客服人员
            if(serSocket == null){//如果没有有空闲的客服人员，向客户发送一条消息
                return false;
            }else{//消息发起人在线，且有空闲的客服人员
                String token = CheckSumBuilder.getMD5(UUID.randomUUID().toString());
                SocketSession socket = new SocketSession(token);
                cusSocket.setRoomToken(socket.getToken());
                serSocket.setRoomToken(socket.getToken());
                socket.setCusSocket(cusSocket);
                socket.setSerSocket(serSocket);
                sessionMap.put(token, socket);
            }
        }
        return true;
    }

    /**
     * 获取链接
     * @param token 链接ID
     * @param curType 1：获取客户端  0：获取服务端
     * @return 对应的链接
     */
    public static WebSocket getClient(String token, Integer curType){
        SocketSession session = sessionMap.get(token);
        if(session == null){
            return null;
        }
        if(curType == 1){//代表当获取客户端
            return session.getCusSocket();
        }else if(curType == 0){//代表当前获取服务端
            return session.getSerSocket();
        }else{
            return null;
        }
    }

    /**
     * 发送信息
     * @param msg 消息主体
     * @param token 房间号
     * @param curType 发送类型
     */
    public static boolean sendMessageTo(String msg, String token, int curType){
        WebSocket socket = ChatRoomSocket.getClient(token, curType);
        if(socket != null){
            socket.sendMessage(msg);
            return false;
        }
        return true;
    }

    public static synchronized void close(String token){
        if(checkConnection(token) == false){
            sessionMap.get(token).getSerSocket().setStatus(0);
            sessionMap.remove(token);
        }
    }

    public static synchronized void closeService(String username){
        for(SocketSession session : sessionMap.values()){
            if(username.equals(session.getSerSocket().getUserName())){
                sessionMap.remove(session);
            }
        }
    }

    public static synchronized boolean checkConnection(String token){
        return sessionMap.get(token) == null ? true : false;
    }

}
