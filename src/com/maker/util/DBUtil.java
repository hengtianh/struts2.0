package com.maker.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;




public class DBUtil implements DataSource {

	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static{
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("market.properties");
		Properties prop = new Properties();
		try{
			prop.load(in);
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			final int connnumber = Integer.parseInt(prop.getProperty("number"));
			Class.forName(driver);
			for(int i=0;i<connnumber;i++){
				final Connection conn = DriverManager.getConnection(url, username, password);
				//pool.add(conn);
				//�Բ��������Ӷ�����д���
				pool.add((Connection)Proxy.newProxyInstance(DBUtil.class.getClassLoader(), 
						new Class[]{com.mysql.jdbc.Connection.class}, new InvocationHandler(){

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						//��close����������ǿ�����õ������ж��Ƿ�Ϊclose����
						String methodName = method.getName();
						if(!methodName.equals("close")){
							//����close������������ԭ���ķ���
							return method.invoke(conn,args);
						}else{
							pool.addLast(conn);
						}
						return null;
					}
					
				}));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized Connection getConnection() {
		// TODO Auto-generated method stub
		if(pool.size()>0){
			return pool.removeFirst();
		}else{
			try {
				return DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				new RuntimeException("������Ϊ��Ӧ");
			}
		}
		return null;
	}
	
	public void release(Connection conn, ResultSet rs, Statement stmt){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			conn = null;
		}
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
