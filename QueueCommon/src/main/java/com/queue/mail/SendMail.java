package com.queue.mail;

import com.queue.mail.entity.EmailEntity;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by liusong on 2018/6/11.
 */
public class SendMail {

    private EmailEntity entity;
    private Properties props;

    public SendMail(EmailEntity entity){
        this.setEntity(entity);
        this.props = new Properties();
        this.props.put("mail.smtp.host", entity.getServerName());
        this.props.put("mail.smtp.auth", "true");
    }

    public void sendMailByEmail(){
        if(props == null){
            throw new NullPointerException("邮件配置为空");
        }
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        try {
            Address from = new InternetAddress(this.getEntity().getAccount());
            msg.setFrom(from);
            if(this.getEntity().getTo() != null){
                Address to = new InternetAddress();
                msg.setRecipient(MimeMessage.RecipientType.TO, to);
            }
            msg.setSubject(this.getEntity().getTitle());
            msg.setContent(this.getEntity().getContent(),"text/html;charset=UTF-8");
            msg.setSentDate(new Date());

            Transport tran = session.getTransport();
            tran.connect(this.getEntity().getAccount(), this.getEntity().getPassword());
            tran.sendMessage(msg, msg.getAllRecipients());
            tran.close();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public EmailEntity getEntity() {
        return entity;
    }

    public void setEntity(EmailEntity entity) {
        this.entity = entity;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
}
