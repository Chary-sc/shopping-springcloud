package com.chary.shopping.util;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendMailUtil {
	
	@Value("1902464856@qq.com")
	private String sendEmail;
	
	@Autowired
	private JavaMailSender sender;
	
	/**
	 * 发送邮件
	 * @param receviceEmail		接收人的邮箱
	 * @param code			验证码
	 * @param nickName			收件人的姓名
	 * @return
	 */
	public boolean sendQQEmail(String receviceEmail, String code, String nickName){
		if(StringUtil.checkNull(receviceEmail,code,nickName)) {
			return false;
		}
	
		try {
			
			MimeMessage mailMessage = sender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);
			
			messageHelper.setTo(receviceEmail);
			messageHelper.setFrom(sendEmail);
			messageHelper.setSubject("果蔬商城注册中心");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			String str = "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body><p style='font-size: 20px;font-weight:bold;'>尊敬的："+nickName+"，您好！</p>"
					+ "<p style='text-indent:2em; font-size: 20px;'>欢迎注册果蔬商城网，您本次的注册码是 "
					+ "<span style='font-size:30px;font-weight:bold;color:red'>" + code + "</span>，3分钟之内有效，请尽快使用！</p>"
					+ "<p style='text-align:right; padding-right: 20px;'"
					+ "<span style='font-size: 18px; float:right; margin-right: 60px;'>" + sdf.format(new Date()) + "</span></body></html>";

			messageHelper.setText(str,true);
			sender.send(mailMessage);
			return true;
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
