package com.my.web4.services;

import java.util.List;

import com.my.web4.entity.Student;

public interface StudentServices {
		/*查询所有学员*/
		public List<Student> findAll(String stuId);
		/*删除学员信息*/
		public boolean delStudent(int id);
		/*修改学员信息*/
		public boolean updStudent(Student stu);
		/*增加学员信息*/
		public boolean addStudent(Student stu);
		/*条件查询学员信息*/
}
