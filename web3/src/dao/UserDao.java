package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
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
	public boolean login(String username,String pwd){
		boolean bool = false;
		String sqlconn ="jdbc:mysql://127.0.0.1:3306/shixun";		
		try {	
			//1:获得连接对象
			Connection conn = DriverManager
			.getConnection(sqlconn,"root","123456");
			//2:创建操作对象
			String sql = "select * from userinfo where username=? AND pwd=?";
			PreparedStatement pst = 
			conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2,pwd);
			//3:创建结果集对象接收查询结果
			ResultSet rs = pst.executeQuery();
			//4:循环读取表当中数据
			while(rs.next()){//是否有下一行数据
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
}
