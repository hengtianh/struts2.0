package com.maker.serviceimpl;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.maker.dao.OrderDao;
import com.maker.dao.UserDao;
import com.maker.daoimpl.OrderDaoImpl;
import com.maker.daoimpl.UserDaoImpl;
import com.maker.entity.Cart;
import com.maker.entity.CartItem;
import com.maker.entity.Product;
import com.maker.entity.User;
import com.maker.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = new OrderDaoImpl();
	UserDao udao = new UserDaoImpl();
	@Override
	public boolean add(User u, Cart c) {
		// �ó����ﳵ�еĶ���ÿһ����������������

		if(c!=null){
			boolean b=false;
			for(CartItem cart : c.getItems()){
				int pid = cart.getProductid();
				int pnumber = cart.getAmount();
				Product p = dao.getNum(pid);
				//System.out.println(p);
				int num = p.getNumber();
				b = dao.createOrder(num-pnumber,pid);
				String email = udao.getByID(p.getId()).getEmail();
				//֪ͨ���ҷ����ʼ�
//				sendEmail(email);
			}
		return b;
		}
		else
			return false;
	}
	private void sendEmail(String address) {
		// TODO �����ʼ�
		
		Properties prop = new Properties();
		prop.setProperty("mail.host", "localhost");
		prop.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(prop);
		try {
			//�õ����Ͷ���
			Transport tr = session.getTransport(new InternetAddress("aaa@163.com"));
			
			//�������
			tr.connect("localhost","tianh","123");
			//�����ʼ�
			Message message = makeMessage(session,address);
			//�����ʼ�
			tr.sendMessage(message, message.getAllRecipients());
			//�ر��ʼ����Ͷ���
			tr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private Message makeMessage(Session session,String address) {
		try{
			// TODO �����ʼ�
			//�����ʼ�����
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(address));
			message.setRecipients(Message.RecipientType.TO, message.getAllRecipients());
			message.setSubject("��������");
			//�����ʼ�������
			InternetHeaders header = new InternetHeaders();
			String str = "������Ʒ�������뼰ʱ������";
		byte[] content = str.getBytes("gb2312");
		MimeBodyPart tt = new MimeBodyPart(header,content);
		
		//�����ʼ�������
		
		//���������ּ�Ĺ�ϵ
		MimeMultipart mmp = new MimeMultipart();
		mmp.addBodyPart(tt);
		mmp.setSubType("related");
		message.setContent(mmp);
		message.saveChanges();
		return message;
		//message.writeTo(new FileOutputStream("e:/1.eml"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean comment(int id) {
		// TODO Auto-generated method stub
		return dao.comment(id);
	}

}
