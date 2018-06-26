package com.queue.mail.entity;

/**
 * Created by liusong on 2018/6/9.
 */
public class EmailEntity {

    private String account;//发送者邮箱
    private String password;//发送邮箱密码
    private String serverName;//邮箱服务器

    private String title;
    private String content;
    private String[] to;//收件人
    private String[] cc;//抄送
    private String[] files;//附件

    public EmailEntity(String account, String password, String serverName){
        this.setAccount(account);
        this.setPassword(password);
        this.setServerName(serverName);
    }

    public void setEntity(String title, String content, String[] to){
        this.setTitle(title);
        this.setContent(content);
        this.setTo(to);
    }

    public void setEntity(String title, String content, String[] to, String[] cc, String[] files){
        this.setTitle(title);
        this.setContent(content);
        this.setTo(to);
        this.setCc(cc);
        this.setFiles(files);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
