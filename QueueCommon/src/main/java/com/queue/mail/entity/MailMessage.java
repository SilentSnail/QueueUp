package com.queue.mail.entity;

/**
 * Created by liusong on 2018/7/12.
 */
public class MailMessage {

    private String subject;//标题
    private String message;//消息
    private String[] toAccount;//收件人
    private String[] ccAccount;//抄送
    private String[] bccAccount;//密送
    private String[] mailFiles;//附件

    public MailMessage() {
    }

    /**
     * 初始化邮件对象
     * @param subject 标题
     * @param message 内容
     * @param toAccount 收件人
     */
    public MailMessage(String subject, String message, String toAccount){
        this(subject, message, new String[]{toAccount});
    }

    /**
     * 初始化邮件对象
     * @param subject 邮件标题
     * @param message 邮件内容
     * @param toAccount 收件人
     */
    public MailMessage(String subject, String message, String[] toAccount){
        this(subject, message, toAccount, null);
    }

    /**
     * 初始化邮件对象
     * @param subject 标题
     * @param message 内容
     * @param toAccount 收件人
     * @param ccAccount 抄送人
     */
    public MailMessage(String subject, String message, String[] toAccount, String[] ccAccount){
        this(subject, message, toAccount, ccAccount, null);
    }

    /**
     * 初始化邮件对象
     * @param subject 标题
     * @param message 内容
     * @param toAccount 收件人
     * @param ccAccount 抄送人
     * @param bccAccount 密送人
     */
    public MailMessage(String subject, String message, String[] toAccount, String[] ccAccount, String[] bccAccount){
        this(subject, message, toAccount, ccAccount, bccAccount, null);
    }

    /**
     * 初始化邮件对象
     * @param subject 标题
     * @param message 内容
     * @param toAccount 收件人
     * @param ccAccount 抄送人
     * @param bccAccount 密送人
     * @param mailFiles 附件
     */
    public MailMessage(String subject, String message, String[] toAccount, String[] ccAccount, String[] bccAccount, String[] mailFiles){
        this.setSubject(subject);
        this.setMessage(message);
        this.setToAccount(toAccount);
        this.setCcAccount(ccAccount);
        this.setBccAccount(bccAccount);
        this.setMailFiles(mailFiles);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getToAccount() {
        return toAccount;
    }

    public void setToAccount(String[] toAccount) {
        this.toAccount = toAccount;
    }

    public String[] getCcAccount() {
        return ccAccount;
    }

    public void setCcAccount(String[] ccAccount) {
        this.ccAccount = ccAccount;
    }

    public String[] getBccAccount() {
        return bccAccount;
    }

    public void setBccAccount(String[] bccAccount) {
        this.bccAccount = bccAccount;
    }

    public String[] getMailFiles() {
        return mailFiles;
    }

    public void setMailFiles(String[] mailFiles) {
        this.mailFiles = mailFiles;
    }
}
