package com.netty.demo;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Mail {
	    public static void main(String[] args) throws Exception{  
	        // 发送器  
	        JavaMailSenderImpl sender = new JavaMailSenderImpl();  
	        sender.setHost("smtp.163.com");  
	        sender.setPort(25); // 默认就是25  
	        sender.setUsername("qingchunjicc@163.com");   
	        sender.setPassword("15380327867wr@");  
	        sender.setDefaultEncoding("UTF-8");  
	          
	        // 配置文件对象  
	        Properties props = new Properties();      
	        props.put("mail.smtp.auth", "true"); // 是否进行验证  
	        Session session = Session.getInstance(props);  
	        sender.setSession(session); // 为发送器指定会话  
	          
	        MimeMessage mail = sender.createMimeMessage();  
	        MimeMessageHelper helper = new MimeMessageHelper(mail, true);  
	        helper.setTo("18626427054@163.com"); // 发送给谁  
	        helper.setSubject("强哥邀请，谁敢不从！"); // 标题  
	        helper.setFrom("qingchunjicc@163.com"); // 来自  
	        helper.setText("123");
	        // 邮件内容，第二个参数指定发送的是HTML格式  
	        helper.setText("<font color='red'>强哥邀请你访问我的博客：http://cuisuqiang.iteye.com/！</font><br><img src='cid:myImg'>",true);  
	        // 增加CID内容  
	        ClassPathResource img = new ClassPathResource("abc.jpg");  
	        helper.addInline("myImg", img);  
	        // 增加附件  
//	        ClassPathResource file = new ClassPathResource("abc.zip");  
//	        helper.addAttachment("abc.zip", file);  
	          
	        sender.send(mail); // 发送  
	          
	        System.out.println("邮件发送成功");  
}
}
