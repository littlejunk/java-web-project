package com.my.web4.services;

import java.util.List;

import com.my.web4.entity.Student;

public interface StudentServices {
		/*��ѯ����ѧԱ*/
		public List<Student> findAll(String stuId);
		/*ɾ��ѧԱ��Ϣ*/
		public boolean delStudent(int id);
		/*�޸�ѧԱ��Ϣ*/
		public boolean updStudent(Student stu);
		/*����ѧԱ��Ϣ*/
		public boolean addStudent(Student stu);
		/*������ѯѧԱ��Ϣ*/
}
