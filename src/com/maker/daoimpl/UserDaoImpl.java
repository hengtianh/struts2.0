package com.maker.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.maker.dao.UserDao;
import com.maker.entity.User;
import com.maker.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	DBUtil util = new DBUtil();
	@Override
	public boolean getByStuID(String stuID) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select id from usertbl where stuID=?";
		boolean result = false;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, stuID);
		    rs = pstmt.executeQuery();
		    if(rs.next()){
		    	result = true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return result;
	}

	@Override
	public boolean add(User user) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="insert into usertbl("
				+ "username,password,sex,stuID,address,phone,isBoss,email) "
				+ "values(?,?,?,?,?,?,?,?)";
		boolean result = false;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, user.getUsername());
		    pstmt.setString(2, user.getPassword());
		    pstmt.setString(3, user.getSex());
		    pstmt.setString(4, user.getStuID());
		    pstmt.setString(5, user.getAddress());
		    pstmt.setString(6, user.getPhone());
		    pstmt.setBoolean(7, user.isBoss());
		    pstmt.setString(8, user.getEmail());
		    int re = pstmt.executeUpdate();
		    if(re>0){
		    	result = true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return result;
	}

	@Override
	public User findByID(String stuID, String password, boolean isBoss) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select * from usertbl where stuID=? and password=? and isBoss=?";
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, stuID);
		    pstmt.setString(2, password);
		    pstmt.setBoolean(3, isBoss);
		    rs = pstmt.executeQuery();
		    if(rs.next()){
		    	User user = new User();
		    	user.setId(rs.getInt(1));
		    	user.setUsername(rs.getString(2));
		    	user.setSex(rs.getString(4));
		    	user.setStuID(rs.getString(5));
		    	user.setAddress(rs.getString(6));
		    	user.setPhone(rs.getString(7));
		    	user.setBoss(rs.getBoolean(8));
		    	user.setEmail(rs.getString(9));
		    	return user;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return null;
	}

	@Override
	public boolean update(String stuID) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		boolean boo = true;
		String sql ="update usertbl set isBoss=? where stuID=?";
		boolean result = false;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setBoolean(1, boo);
		    pstmt.setString(2, stuID);
		    int re = pstmt.executeUpdate();
		    if(re>0){
		    	result = true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return result;
	}

	@Override
	public User getByID(int id) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select email from Usertbl where id=?";
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, id);
		    rs = pstmt.executeQuery();
		    if(rs.next()){
		    	User u = new User();
		    	u.setEmail(rs.getString(1));
		    	return u;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return null;
	}

}
