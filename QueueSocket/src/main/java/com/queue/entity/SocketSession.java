package com.queue.entity;

import java.util.Date;

/**
 * Created by liusong on 2018/4/18.
 */
public class SocketSession {

    private String token;
    private WebSocket cusSocket;
    private WebSocket serSocket;
    private Date time;

    public SocketSession(String token){
        this.token = token;
        this.time = new Date();
    }

    public SocketSession(String token, WebSocket cusSocket, WebSocket serSocket){
        this.token = token;
        this.cusSocket = cusSocket;
        this.serSocket = serSocket;
        this.time = new Date();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public WebSocket getCusSocket() {
        if(cusSocket.getSession().isOpen()){
            return cusSocket;
        }
        return null;
    }

    public void setCusSocket(WebSocket cusSocket) {
        this.cusSocket = cusSocket;
    }

    public WebSocket getSerSocket() {
        if(serSocket.getSession().isOpen()){
            return serSocket;
        }
        return null;
    }

    public void setSerSocket(WebSocket serSocket) {
        this.serSocket = serSocket;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
