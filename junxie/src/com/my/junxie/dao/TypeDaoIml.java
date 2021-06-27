package com.my.junxie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.junxie.entity.WeaponType;


public class TypeDaoIml extends DBhelper implements TypeDao {

	@Override
	public List<WeaponType> findAll(String typeId) {
		List<WeaponType> list = new ArrayList<WeaponType>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from weapontype ";
        if(typeId != null && typeId.length()>0){
        	sql += " where typeId= "+ Integer.parseInt(typeId);
        }
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				WeaponType weaponType = new WeaponType(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(weaponType);
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
	public boolean delete(int typeId) {
		String sql = "delete from weapontype where typeId=?";
		Object[] param = {typeId};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean update(WeaponType weaponType) {
		String sql = "update weapontype set typeName=? , isUse=? where typeId=? ";
		Object[] pamars = {weaponType.getTypeName(),weaponType.getIsUse(),weaponType.getTypeId()};
		return sqlUpdate(sql, pamars);
	}

	@Override
	public boolean add(WeaponType weaponType) {
		String sql = "insert into weapontype values(?,?,?)";
		Object[] param = {weaponType.getTypeId(),weaponType.getTypeName(),weaponType.getIsUse()};
		return sqlUpdate(sql, param);
	}

	@Override
	public List<WeaponType> findInUse() {
		List<WeaponType> list = new ArrayList<WeaponType>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from weapontype where isUse=1";
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				WeaponType weaponType = new WeaponType(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(weaponType);
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
