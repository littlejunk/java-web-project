package com.my.web4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBhelper {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Ç×£¬Çý¶¯°üÄØ£¿");
			e.printStackTrace();
		}	
	}
	
	public Connection getConn() {
		String url = "jdbc:mysql://127.0.0.1:3306/shixun";
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(url, "root", "123456");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	public boolean sqlUpdate(String sql,Object[] param) {
        boolean bool = false;
        Connection connection = null;
        PreparedStatement pst = null;
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			for(int i=0; i<param.length;i++){
				pst.setObject(i+1,param[i] );
			}
			bool = pst.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(connection, pst, null);
		}
        System.out.println(bool);
        return bool;
        
	}
	
	public void close(Connection conn, PreparedStatement pst, ResultSet rs){

		try {
			if(rs != null){
				rs.close();
			}
			if(pst != null){
				pst.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
