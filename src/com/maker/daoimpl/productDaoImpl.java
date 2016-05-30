package com.maker.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.maker.dao.ProductDao;
import com.maker.entity.Page;
import com.maker.entity.Product;
import com.maker.util.DBUtil;

public class productDaoImpl implements ProductDao {

	private DBUtil util = new DBUtil();
	@Override
	public int getRecord(int cateid) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select count(*) from product where cateid=?";
		int result = 0;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, cateid);
		    rs = pstmt.executeQuery();
		    while(rs.next()){
		    	result++;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
//		System.out.println("个数："+result);
		return result;
	}

	
	@Override
	public boolean add(Product p) {
		//添加商品
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="insert into product(id,cateID,productname,price,number,image,description) values(?,?,?,?,?,?,?)";
		boolean result = false;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, p.getId());
		    pstmt.setInt(2, p.getCateID());
		    pstmt.setString(3, p.getProductname());
		    pstmt.setDouble(4, p.getPrice());
		    pstmt.setInt(5, p.getNumber());
		    pstmt.setString(6, p.getImage());
		    pstmt.setString(7, p.getDescription());
		    int re = pstmt.executeUpdate();
		    if(re>0)
		    	result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return result;
	}

	@Override
	public List findSome(String productname) {
		// 模糊查询指定名称的物品
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select * from product where productname=? ";
		List<Product> list = new ArrayList<Product>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productname);
		    rs = pstmt.executeQuery();
		   while(rs.next()){
			   Product p = new Product();
			   p.setProductID(rs.getInt(1));
			   p.setId(rs.getInt(2));
			   p.setCateID(rs.getInt(3));
			   p.setProductname(rs.getString(4));
			   p.setPrice(rs.getDouble(5));
			   p.setNumber(rs.getInt(6));
			   p.setImage(rs.getString(7));
			   p.setDescription(rs.getString(8));
			   list.add(p);
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
	public List findByid(int cateid , Page page) {
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select * from product where cateID=? limit ?,?";
		List<Product> list = new ArrayList<Product>();
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, cateid);
		    pstmt.setInt(2, page.getStartIndex()-1);
		    pstmt.setInt(3, page.getSize());
		    rs = pstmt.executeQuery();
		   while(rs.next()){
			   Product p = new Product();
			   p.setProductID(rs.getInt(1));
			   p.setId(rs.getInt(2));
			   p.setCateID(rs.getInt(3));
			   p.setProductname(rs.getString(4));
			   p.setPrice(rs.getDouble(5));
			   p.setNumber(rs.getInt(6));
			   p.setImage(rs.getString(7));
			   p.setDescription(rs.getString(8));
			   list.add(p);
		    }
//		   System.out.println("list的大小为："+list.size());
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
	public List findBest() {
		
		return null;
	}


	@Override
	public List getByUserId(int userid) {
		// TODO 查找商家在售商品
		
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="select * from product where id=?";
		List<Product> list = new ArrayList<Product>();
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, userid);
		    rs = pstmt.executeQuery();
		   while(rs.next()){
			   Product p = new Product();
			   p.setProductID(rs.getInt(1));
			   p.setId(rs.getInt(2));
			   p.setCateID(rs.getInt(3));
			   p.setProductname(rs.getString(4));
			   p.setPrice(rs.getDouble(5));
			   p.setNumber(rs.getInt(6));
			   p.setImage(rs.getString(7));
			   p.setDescription(rs.getString(8));
			   list.add(p);
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
	public boolean update(Product p) {
		// TODO Auto-generated method stub
		Connection conn = util.getConnection();
		ResultSet rs =null;
		PreparedStatement pstmt = null;
		String sql ="update product set productname=? , price=? , number=? , description=? where id=? and productid=?";
		boolean result = false;
		try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, p.getId());
		    pstmt.setInt(2, p.getCateID());
		    pstmt.setString(3, p.getProductname());
		    pstmt.setDouble(4, p.getPrice());
		    pstmt.setInt(5, p.getNumber());
		    pstmt.setString(6, p.getImage());
		    pstmt.setString(7, p.getDescription());
		    int re = pstmt.executeUpdate();
		    if(re>0)
		    	result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.release(conn, rs, pstmt);
		}
		return result;
	}

}
