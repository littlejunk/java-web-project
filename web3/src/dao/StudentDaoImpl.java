package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class StudentDaoImpl extends DBhelper implements StudentDao{
	@Override
	public List<Student> findAll(String stuId) {
		List<Student> list = new ArrayList<Student>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from student";
        if(stuId != null && stuId.length()>0){
        	sql += " where stuId = "+ Integer.parseInt(stuId);
        }
        try {
			connection = getConn();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));
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
	public boolean delStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from student where stuId=?";
		Object[] param = {id};
		return sqlUpdate(sql, param);
	}

	@Override
	public boolean updStudent(Student stu) {
		// TODO Auto-generated method stub
		String sql = "update student set stuName=? , stuAge=? , stuSex=? ,classId=? where stuId=? ";
		Object[] pamars = {stu.getStuName(),stu.getStuAge(),stu.getStuSex(),stu.getClassId(),stu.getStuId()};
		return sqlUpdate(sql, pamars);
	}

	@Override
	public boolean addStudent(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}

}
