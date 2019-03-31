package com.queue.entity;

import javax.websocket.Session;

/**
 * Created by liusong on 2018/4/17.
 */
public class WebSocket {

    private Session session;
    private String userName;//用户名
    private String token;
    private String roomToken;
    private Integer status;

    public WebSocket(){
        this.status = 0;
    }

    public WebSocket(String userName, Session session){
        this.userName = userName;
        this.session = session;
        this.status = 0;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void sendMessage(String msg){
        this.session.getAsyncRemote().sendText(msg);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomToken() {
        return roomToken;
    }

    public void setRoomToken(String roomToken) {
        this.roomToken = roomToken;
    }
}
