package com.maker.util;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class MailUtil{
	//生成一封邮件
	public static void main(String[] args){
		//获得session
		Session session = Session.getInstance(new Properties());
		
		//创建邮件对象
		MimeMessage message = new MimeMessage(session);
		
		//创建邮件各部分
		InternetHeaders header = new InternetHeaders();
		String str = "您有商品卖出，请及时发货！";
		try{
		byte[] content = str.getBytes("utf-8");
		MimeBodyPart tt = new MimeBodyPart(header,content);
		
		//创建邮件的内容
		
		//关联各部分间的关系
		MimeMultipart mmp = new MimeMultipart();
		mmp.addBodyPart(tt);
		mmp.setSubType("related");
		message.setContent(mmp);
		message.saveChanges();
		message.writeTo(new FileOutputStream("e:/1.eml"));
		}catch(Exception e){
			
		}
	}
	
}
