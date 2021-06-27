package com.my.junxie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.junxie.entity.Arm;
import com.my.junxie.entity.WeaponType;

public class ArmDaoIml extends DBhelper implements ArmDao{

	@Override
	public List<Arm> findAll(String armId) {
		List<Arm> list = new ArrayList<Arm>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select a.armId,a.armName,a.bullet,a.shotRange,a.typeId,b.typeName ,b.isUse from arms a,weapontype b where a.typeId=b.typeId ";
        if(armId != null && armId.length()>0){
        	sql += " and a.armId= "+ Integer.parseInt(armId);
        }
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				if(rs.getInt(7)==1){
					WeaponType weaponType = new WeaponType(rs.getInt(5), rs.getString(6), rs.getInt(7));
					Arm arm = new Arm(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getInt(5));
					arm.setWeaponType(weaponType);
					list.add(arm);
				}
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
	public boolean delete(String armId) {
		String sql = "delete from arms where armId=?";
		Object[] param = {armId};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean add(Arm arm) {
		String sql = "insert into arms values(?,?,?,?,?)";
		Object[] param = {arm.getArmId(),arm.getArmName(),arm.getBullet(),arm.getShotRange(),arm.getTypeId()};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean update(Arm arm) {
		String sql = "update arms set armName=? , bullet=?, shotRange=?, typeId=?  where armId=? ";
		Object[] pamars = {arm.getArmName(),arm.getBullet(),arm.getShotRange(),arm.getTypeId(),arm.getArmId()};
		return sqlUpdate(sql, pamars);
	}
   
}
