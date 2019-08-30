package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@Controller
@RequestMapping("email")
public class Email {
	
	@Autowired
	JavaMailSender jms;
	
	@RequestMapping("/send")
	@ResponseBody
	public String send(){
		//建立邮件消息
		SimpleMailMessage mainMessage = new SimpleMailMessage();
		//发送者
		mainMessage.setFrom("15650229572@163.com");
		//接收者
		mainMessage.setTo("981176139@qq.com");
		//发送的标题
		mainMessage.setSubject("嗨喽");
		//发送的内容
		mainMessage.setText("hello world");
		jms.send(mainMessage);
		return "1";
	}
}

//@Component("emailtool")
//public class Email {
//	 @Autowired
//	 private JavaMailSender javaMailSender;
//	 public void sendSimpleMail(){
//	        MimeMessage message = null;
//	        try {
//	            message = javaMailSender.createMimeMessage();
//	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//	            helper.setFrom("981176139@qq.com");
//	            helper.setTo("15650229572@163.com");
//	            helper.setSubject("标题：发送内容");
//
//	            StringBuffer sb = new StringBuffer();
//	            sb.append("已发送");
//	                    
//	            helper.setText(sb.toString(), true);
//	            FileSystemResource fileSystemResource=new FileSystemResource(new File("D:\76678.pdf"));
//	            //helper.addAttachment("电子发票"，fileSystemResource);
//	            helper.addAttachment("电子发票", fileSystemResource);
//	            javaMailSender.send(message);
//	        } catch (MessagingException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	
//}
