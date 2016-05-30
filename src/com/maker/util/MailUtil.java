package com.maker.util;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class MailUtil{
	//����һ���ʼ�
	public static void main(String[] args){
		//���session
		Session session = Session.getInstance(new Properties());
		
		//�����ʼ�����
		MimeMessage message = new MimeMessage(session);
		
		//�����ʼ�������
		InternetHeaders header = new InternetHeaders();
		String str = "������Ʒ�������뼰ʱ������";
		try{
		byte[] content = str.getBytes("utf-8");
		MimeBodyPart tt = new MimeBodyPart(header,content);
		
		//�����ʼ�������
		
		//���������ּ�Ĺ�ϵ
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
