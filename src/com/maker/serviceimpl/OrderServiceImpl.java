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
		// 拿出购物车中的东西每一个都更新他的数量

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
				//通知卖家发送邮件
//				sendEmail(email);
			}
		return b;
		}
		else
			return false;
	}
	private void sendEmail(String address) {
		// TODO 发送邮件
		
		Properties prop = new Properties();
		prop.setProperty("mail.host", "localhost");
		prop.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(prop);
		try {
			//得到发送对象
			Transport tr = session.getTransport(new InternetAddress("aaa@163.com"));
			
			//获得连接
			tr.connect("localhost","tianh","123");
			//创建邮件
			Message message = makeMessage(session,address);
			//发送邮件
			tr.sendMessage(message, message.getAllRecipients());
			//关闭邮件发送对象
			tr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private Message makeMessage(Session session,String address) {
		try{
			// TODO 生成邮件
			//创建邮件对象
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(address));
			message.setRecipients(Message.RecipientType.TO, message.getAllRecipients());
			message.setSubject("发货提醒");
			//创建邮件各部分
			InternetHeaders header = new InternetHeaders();
			String str = "您有商品卖出，请及时发货！";
		byte[] content = str.getBytes("gb2312");
		MimeBodyPart tt = new MimeBodyPart(header,content);
		
		//创建邮件的内容
		
		//关联各部分间的关系
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
