package com.queue.mail.util;

import com.queue.mail.entity.MailMessage;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created by liusong on 2018/7/12.
 */
public class MailUtil {

    //信息配置
    private static Properties config = new Properties();
    private static Properties props;
    private static Boolean debug = false;
    private static Session session;
    private static String account;
    private static String password;

    static{
        try {
//            InputStream io = MailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
            InputStream io = new FileInputStream("/Volumes/TEST_HD/Document/mail.properties");
            config.load(io);
            props = new Properties();
            props.put("mail.smtp.auth", config.get("mail.auth"));
            props.put("mail.smtp.host", config.get("mail.host"));
            props.put("mail.transport.protocol", config.get("mail.transport"));
            debug = Boolean.parseBoolean(String.valueOf(config.get("mail.debug")));
            account = String.valueOf(config.get("mail.account"));
            password = String.valueOf(config.get("mail.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送邮件
     * @param mail
     * @throws RuntimeException
     * @throws MessagingException
     */
    public static void sendMail(MailMessage mail) throws RuntimeException, MessagingException {
        Message msg;//声明消息对象
        try {
            session = Session.getDefaultInstance(props);//初始化默认消息对象
            session.setDebug(debug);//设置调试模式
            msg = parseMessage(session, mail);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("邮件对象初始化失败");
        }
        Transport trans;
        try {
            System.out.println(msg);
            trans = session.getTransport();
            trans.connect(account, password);
            trans.sendMessage(msg, msg.getAllRecipients());
            trans.close();
        } catch (MessagingException e) {
            throw e;
        }
    }

    private static MimeMessage parseMessage(Session sion, MailMessage message) throws MessagingException {
        MimeMessage msg = new MimeMessage(sion);//创建邮件消息对象
        msg.setFrom(new InternetAddress(account));//指定发送人
        msg.setRecipients(Message.RecipientType.TO, getParseAddress(message.getToAccount()));//指定收件人
        msg.setRecipients(Message.RecipientType.CC, getParseAddress(message.getCcAccount()));//指定抄送人
        msg.setRecipients(Message.RecipientType.BCC, getParseAddress(message.getBccAccount()));//指定密送人
        msg.setSubject(message.getSubject());//添加邮件标题
        msg.setContent(getParseMultipart(message.getMessage(), message.getMailFiles()));//添加邮件内容
        msg.setSentDate(new Date());//添加邮件发送时间
        return msg;
    }

    /**
     * 设置收件人信息
     * @param acc
     * @return
     * @throws AddressException
     */
    private static Address[] getParseAddress(String[] acc) throws AddressException {
        if(acc == null || acc.length <= 0){
            return null;
        }
        Address[] accs = new InternetAddress[acc.length];
        for (int i = 0; i < accs.length; i++) {
            accs[i] = new InternetAddress(acc[i]);
        }
        return accs;
    }

    /**
     * 设置附件
     * @param message
     * @param files
     * @return
     * @throws MessagingException
     */
    private static Multipart getParseMultipart(String message, String[] files) throws MessagingException {
        Multipart mult = new MimeMultipart();//创建多重消息对象
        BodyPart body = new MimeBodyPart();
        body.setContent(message, "text/html;charset=utf-8");
        mult.addBodyPart(body);
        if(files != null && files.length > 0){
            BodyPart part;
            for (int i = 0; i < files.length; i++) {
                part = new MimeBodyPart();
                FileDataSource dataSource = new FileDataSource(files[i].split(",")[0]);
                part.setDataHandler(new DataHandler(dataSource));
                part.setFileName(files[i].split(",")[1]);
                mult.addBodyPart(part);
            }
        }
        return mult;
    }

    public static void main(String[] args) {
        try {
            MailUtil.sendMail(new MailMessage("邮件标题","邮件内容","123456@163.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
