package com.netty.demo;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Mail {
	    public static void main(String[] args) throws Exception{  
	        // ������  
	        JavaMailSenderImpl sender = new JavaMailSenderImpl();  
	        sender.setHost("smtp.163.com");  
	        sender.setPort(25); // Ĭ�Ͼ���25  
	        sender.setUsername("qingchunjicc@163.com");   
	        sender.setPassword("15380327867wr@");  
	        sender.setDefaultEncoding("UTF-8");  
	          
	        // �����ļ�����  
	        Properties props = new Properties();      
	        props.put("mail.smtp.auth", "true"); // �Ƿ������֤  
	        Session session = Session.getInstance(props);  
	        sender.setSession(session); // Ϊ������ָ���Ự  
	          
	        MimeMessage mail = sender.createMimeMessage();  
	        MimeMessageHelper helper = new MimeMessageHelper(mail, true);  
	        helper.setTo("18626427054@163.com"); // ���͸�˭  
	        helper.setSubject("ǿ�����룬˭�Ҳ��ӣ�"); // ����  
	        helper.setFrom("qingchunjicc@163.com"); // ����  
	        helper.setText("123");
	        // �ʼ����ݣ��ڶ�������ָ�����͵���HTML��ʽ  
	        helper.setText("<font color='red'>ǿ������������ҵĲ��ͣ�http://cuisuqiang.iteye.com/��</font><br><img src='cid:myImg'>",true);  
	        // ����CID����  
	        ClassPathResource img = new ClassPathResource("abc.jpg");  
	        helper.addInline("myImg", img);  
	        // ���Ӹ���  
//	        ClassPathResource file = new ClassPathResource("abc.zip");  
//	        helper.addAttachment("abc.zip", file);  
	          
	        sender.send(mail); // ����  
	          
	        System.out.println("�ʼ����ͳɹ�");  
}
}
