package com.maker.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.maker.dao.TypeDao;
import com.maker.entity.Category;
import com.maker.entity.Type;
import com.maker.util.DBUtil;

public class TypeDaoImpl implements TypeDao {

	private DBUtil util = new DBUtil();
	@Override
	public boolean addType(Type type) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="insert into type(typename) values(?)";
		boolean result = false;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, type.getTypename());
		    int r = pstmt.executeUpdate();
		    if(r>0){
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
	public List getAll() {
		
		//获得所有的type
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select * from type";
		List<Type> list = new ArrayList<Type>();
		try {
		    pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		   while(rs.next()){
			   Type type = new Type();
			   type.setTypeid(rs.getInt(1));
			   type.setTypename(rs.getString(2));
			   list.add(type);
		    }
		   return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return null;
	}

	@Override
	public boolean addCate(Category cg) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="insert into category(typeid,catename) values(?,?)";
		boolean result = false;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, cg.getTypeid());
		    pstmt.setString(2, cg.getCatename());
		    int r = pstmt.executeUpdate();
		    if(r>0){
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
	public List getAllCate() {
		//获得所有的分类
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select * from category";
		List<Category> list = new ArrayList<Category>();
		try {
		    pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		   while(rs.next()){
			   Category cate = new Category();
			   cate.setCateid(rs.getInt(1));
			   cate.setTypeid(rs.getInt(2));
			   cate.setCatename(rs.getString(3));
			   list.add(cate);
		    }
		   return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return null;
	}

}
