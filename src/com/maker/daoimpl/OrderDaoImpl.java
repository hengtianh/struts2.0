package com.maker.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maker.dao.OrderDao;
import com.maker.entity.Product;
import com.maker.util.DBUtil;

public class OrderDaoImpl implements OrderDao {
	private DBUtil util = new DBUtil();
	@Override
	public boolean createOrder(int number,int pid) {
		// TODO 更新数量信息，生成发货邮件
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql = "update product set number=? where productID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setInt(2, pid);
			int result = pstmt.executeUpdate();
			if(result>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return false;
	}
	@Override
	public boolean comment(int id) {
		// TODO 订单评论
		return false;
		
	}
	@Override
	public Product getNum(int productid) {
		// TODO Auto-generated method stub
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql = "select number from product where productID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			//System.out.println(pstmt);
			pstmt.setInt(1, productid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product p =new Product();
				p.setNumber(rs.getInt(1));
				return p;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
