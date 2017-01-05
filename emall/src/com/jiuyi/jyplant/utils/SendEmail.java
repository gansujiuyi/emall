package com.jiuyi.jyplant.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static  String EMAILL_HOST = ConfigManager.getString("EMAILL_HOST", "smtp.163.com");
	public static  String PROTOCOL = ConfigManager.getString("PROTOCOL", "smtp");
	public static  String PORT = ConfigManager.getString("PORT", "25");
	public static  String EMAILL_FROM = ConfigManager.getString("EMAILL_FROM", "18701573998@139.com");// 发件人的email
	public static  String EMAILL_PWD = ConfigManager.getString("EMAILL_PWD", "Bzl123456");// 发件人密码
	
	/**
     * 获取Session
     * @return
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", EMAILL_HOST);//设置服务器地址
        props.put("mail.store.protocol" , PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.smtp.auth" , true);

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAILL_FROM, EMAILL_PWD);
            }
        };
        Session session = Session.getDefaultInstance(props , authenticator);

        return session;
    }

    public static void send(String toEmail , String content) {
        Session session = getSession();
        try {
//            System.out.println("--send--"+content);
            // Instantiate a message
            Message msg = new MimeMessage(session);
            //Set message attributes
            msg.setFrom(new InternetAddress(EMAILL_FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("久易购账号激活邮件");
            msg.setSentDate(new Date());
            msg.setContent(content , "text/html;charset=utf-8");

            //Send the message
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
