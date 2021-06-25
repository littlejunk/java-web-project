package com.my.web4.services;

import java.util.List;

import com.my.web4.dao.StudentDao;
import com.my.web4.dao.StudentDaoImpl;
import com.my.web4.entity.Student;

public class StudentServicesIml implements StudentServices{
   
	StudentDao studentDao = new StudentDaoImpl();
	@Override
	public List<Student> findAll(String stuId) {
		// TODO Auto-generated method stub
		return studentDao.findAll(stuId);
	}

	@Override
	public boolean delStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.delStudent(id);
	}

	@Override
	public boolean updStudent(Student stu) {
		// TODO Auto-generated method stub
		return studentDao.updStudent(stu);
	}

	@Override
	public boolean addStudent(Student stu) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(stu);
	}

}
