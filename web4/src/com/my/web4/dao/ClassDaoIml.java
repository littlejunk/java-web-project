package com.my.web4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.web4.entity.ClassInfo;

public class ClassDaoIml extends DBhelper implements ClassDao{

	@Override
	public List<ClassInfo> findAll(String classId) {
		List<ClassInfo> list = new ArrayList<ClassInfo>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from classInfo ";
        if(classId != null && classId.length()>0){
        	sql += " where classId= "+ Integer.parseInt(classId);
        }
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				ClassInfo classInfo = new ClassInfo(rs.getInt(1), rs.getString(2));
				list.add(classInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(connection, pst, rs);
		}
		return list;
	}
   
}
