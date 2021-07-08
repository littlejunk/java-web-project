package com.my.medicinemanage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.medicinemanage.entity.Manager;
import com.my.medicinemanage.entity.Shelve;
import com.my.medicinemanage.entity.User;

public class UserDaoIml extends DBhelper implements UserDao {
	//加载驱动类
	static{ //静态块 优先执行，且一次
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("亲，驱动包呢？");
			e.printStackTrace();
		}	
	}
	/* 登录 true=成功 false=失败  */
	public User login(String username,String pwd){
		User user = null;
		String sqlconn ="jdbc:mysql://127.0.0.1:3306/shixun";		
		try {	
			//1:获得连接对象
			Connection conn = DriverManager
			.getConnection(sqlconn,"root","123456");
			//2:创建操作对象
			String sql = "select * from userinfo where userName=? AND password=?";
			PreparedStatement pst = 
			conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2,pwd);
			//3:创建结果集对象接收查询结果
			ResultSet rs = pst.executeQuery();
			//4:循环读取表当中数据
			while(rs.next()){//是否有下一行数据
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public Manager manlogin(String userName, String password) {
		Manager manager = null;
		String sqlconn ="jdbc:mysql://127.0.0.1:3306/shixun";		
		try {	
			//1:获得连接对象
			Connection conn = DriverManager
			.getConnection(sqlconn,"root","123456");
			//2:创建操作对象
			String sql = "select * from manager where maname=? AND manpwd=?";
			PreparedStatement pst = 
			conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2,password);
			//3:创建结果集对象接收查询结果
			ResultSet rs = pst.executeQuery();
			//4:循环读取表当中数据
			while(rs.next()){//是否有下一行数据
				manager = new Manager(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}
	@Override
	public List<User> findAll(String userId) {
		List<User> list = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from userinfo ";
        if(userId != null && userId.length()>0){
        	sql += " where userId= "+ Integer.parseInt(userId);
        }
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(connection, pst, rs);
		}
		return list;
	}
	@Override
	public boolean update(User user) {
		String sql = "update userinfo set userRole=?  where userName=? ";
		Object[] pamars = {user.getUserRole(),user.getUserName()};
		return sqlUpdate(sql, pamars);
	}
	@Override
	public boolean delete(int userId) {
		String sql = "delete from userinfo where userId=?";
		Object[] param = {userId};
		return sqlUpdate(sql, param);
	}
	@Override
	public boolean add(User user) {
		    int maxSheId = 0;
		    Connection connection = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        String sql1 = "select max(userId) from userinfo ";
	        try {
				connection = getConn();
				pst = connection.prepareStatement(sql1);
				rs = pst.executeQuery();
				while(rs.next()){
					maxSheId = rs.getInt(1)+1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String sql = "insert into userinfo values(?,?,?,?)";
		Object[] pamars = {maxSheId,user.getUserName(),user.getPassword(),user.getUserRole()};
		return sqlUpdate(sql, pamars);
	}
}
