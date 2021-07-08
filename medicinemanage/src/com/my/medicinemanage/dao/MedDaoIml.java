package com.my.medicinemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;








import com.my.medicinemanage.entity.Medicine;
import com.my.medicinemanage.entity.Shelve;

public class MedDaoIml extends DBhelper implements MedDao {

	@Override
	public List<Medicine> findAll(String medId) {
		List<Medicine> list = new ArrayList<Medicine>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select a.medId,a.medName,a.medPrice,a.medNum,a.production,a.shelife ,a.sheId,b.sheName,b.sheCap "+
        " from medicine a,shelves b where a.sheId=b.sheId ";
        if(medId != null && medId.length()>0){
        	sql += " and a.medId= "+ Integer.parseInt(medId);
        }
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
					Shelve shelve = new Shelve(rs.getInt(7), rs.getInt(9), rs.getString(8));
					Medicine medicine = new Medicine(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4),
							rs.getString(5), rs.getString(6), rs.getInt(7));
					medicine.setShelve(shelve);
					list.add(medicine);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(connection, pst, rs);
		}
        Collections.sort(list);
		return list;
	}

	@Override
	public boolean delete(String medId) {
		String sql = "delete from medicine where medId=?";
		Object[] param = {medId};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean add(Medicine medicine) {
		int sheId = medicine.getSheId();
		SheDao sd = new SheDaoIml();
		Shelve shelve = sd.findAll(Integer.toString(sheId)).get(0);
		if(shelve.getSheCurrentCap()<medicine.getMedNum()){
			return false;
		}else {
			//ÕÒµ½×î´óid
			    int maxMedId = 0;
			    Connection connection = null;
		        PreparedStatement pst = null;
		        ResultSet rs = null;
		        String sql1 = "select max(medId) from medicine ";
		        try {
					connection = getConn();
					pst = connection.prepareStatement(sql1);
					rs = pst.executeQuery();
					while(rs.next()){
						maxMedId = rs.getInt(1)+1;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			String sql = "insert into medicine values(?,?,?,?,?,?,?)";
			Object[] param = {maxMedId,medicine.getMedName(),medicine.getMedPrice(),medicine.getMedNum(),medicine.getProduction(),
					medicine.getSheLife(),medicine.getSheId()
			};
			return sqlUpdate(sql, param);
		}
	}

	@Override
	public boolean update(Medicine medicine) {
		int sheId = medicine.getSheId();
		SheDao sd = new SheDaoIml();
		Shelve shelve = sd.findAll(Integer.toString(sheId)).get(0);
		String sql = "update medicine set medPrice=?, medNum=?,sheId=? where medId=? ";
		Object[] param = {medicine.getMedPrice(),medicine.getMedNum(),medicine.getSheId(),
				medicine.getMedId()
        };
		if(sheId==findAll(Integer.toString(medicine.getMedId())).get(0).getSheId()){
			int changeNum = medicine.getMedNum()- findAll(Integer.toString(medicine.getMedId())).get(0).getMedNum();
			if(shelve.getSheCurrentCap()>=changeNum){
				return sqlUpdate(sql, param);
			}else {
				return false;
			}
		}else {
			if(findAll(Integer.toString(medicine.getMedId())).get(0).getMedNum()<=sd.findAll(Integer.toString(medicine.getSheId()))
				  .get(0).getSheCurrentCap()){
				return sqlUpdate(sql, param);
			}else {
				return false;
			}
		}
	}

	@Override
	public List<Medicine> findByKey(String key) {
		List<Medicine> list = new ArrayList<Medicine>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select a.medId,a.medName,a.medPrice,a.medNum,a.production,a.shelife ,a.sheId,b.sheName,b.sheCap "+
        " from medicine a,shelves b where (a.medName like '%"+key +"%' or b.sheName like '%"+key+"%') and a.sheId=b.sheId";
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
					Shelve shelve = new Shelve(rs.getInt(7), rs.getInt(9), rs.getString(8));
					Medicine medicine = new Medicine(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4),
							rs.getString(5), rs.getString(6), rs.getInt(7));
					medicine.setShelve(shelve);
					list.add(medicine);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(connection, pst, rs);
		}
        Collections.sort(list);
		return list;
        
	}
  
}
