package com.my.medicinemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.medicinemanage.entity.Shelve;

public class SheDaoIml extends DBhelper implements SheDao {

	@Override
	public List<Shelve> findAll(String sheId) {
		List<Shelve> list = new ArrayList<Shelve>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from shelves ";
        if(sheId != null && sheId.length()>0){
        	sql += " where sheId= "+ Integer.parseInt(sheId);
        }
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Shelve shelve = new Shelve(rs.getInt(1), rs.getInt(3), rs.getString(2));
				list.add(shelve);
			}
			int beUsed = 0;
			String sql1 = "select medNum from medicine where sheId= ";
			for(int i=0;i<list.size();i++){
		        pst = connection.prepareStatement(sql1+list.get(i).getSheId());
		        rs = pst.executeQuery();
		        while(rs.next()){
		        	beUsed += rs.getInt(1);
		        }
		        list.get(i).setSheCurrentCap(list.get(i).getSheCap()-beUsed);
		        beUsed = 0;
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
	public boolean delete(int sheId) {
		String sql = "delete from shelves where sheId=?";
		Object[] param = {sheId};
		String sql1 = "delete from medicine where sheId=?";
		Object[] param1 = {sheId};
		sqlUpdate(sql1, param1);
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean update(Shelve shelve) {
		String sql = "update shelves set sheName=? , sheCap=? where sheId=? ";
		Object[] pamars = {shelve.getSheName(),shelve.getSheCap(),shelve.getSheId()};
		return sqlUpdate(sql, pamars);
	}

	@Override
	public boolean add(Shelve shelve) {
		    int maxSheId = 0;
		    Connection connection = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        String sql1 = "select max(sheId) from shelves ";
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
		String sql = "insert into shelves values(?,?,?)";
		Object[] pamars = {maxSheId,shelve.getSheName(),shelve.getSheCap()};
		return sqlUpdate(sql, pamars);
	}
     
}
