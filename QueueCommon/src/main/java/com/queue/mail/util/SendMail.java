package com.queue.mail.util;

import com.queue.mail.entity.MailMessage;

import javax.mail.MessagingException;

/**
 * Created by liusong on 2018/6/27.
 */
public class SendMail implements Runnable {

    private MailMessage mail;

    public SendMail(){}

    public SendMail(MailMessage mail){
        this.mail = mail;
    }

    public void setMail(MailMessage mail) {
        this.mail = mail;
    }

    public void run() {
        try {
            MailUtil.sendMail(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
