package com.maker.test;

import java.sql.Connection;
import java.sql.SQLException;


import com.maker.util.DBUtil;

public class TestDB {
	public static void main(String[] args) throws SQLException {
		DBUtil util = new DBUtil();
		Connection conn1 = util.getConnection();
		Connection conn2 = util.getConnection();
		Connection conn3 = util.getConnection();
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
		conn1.close();
		conn2.close();
		conn3.close();
	}
}
