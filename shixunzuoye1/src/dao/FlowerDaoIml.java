package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Flower;

public class FlowerDaoIml implements FlowerDao {

	@Override
	public boolean insert(Flower flower) {
		// TODO Auto-generated method stub
		String sql = "insert into flower values(?,?,?,?,?,?)";
		Object[] param = {flower.getId(),flower.getName(),flower.getNickName(),
				flower.getProperty(),flower.getPrice(),flower.getProduction()};
		return DBhelper.sqlUpdate(sql, param);
	}

	@Override
	public List<Flower> findAll() {
		// TODO Auto-generated method stub
		List<Flower> list = new ArrayList<Flower>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			connection = DBhelper.getConn();
			pst = connection.prepareStatement("select * from flower");
			rs = pst.executeQuery();
			while(rs.next()){
				list.add(new Flower(rs.getInt(1),rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getFloat(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBhelper.close(connection, pst, rs);
		}
		
		return list;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from flower where id=?";
		Object[] param = {id};
		return DBhelper.sqlUpdate(sql, param);
		
	}

}
