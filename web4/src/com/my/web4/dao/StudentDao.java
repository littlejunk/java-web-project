package com.my.web4.dao;

import java.util.List;

import com.my.web4.entity.*;


 public interface StudentDao {
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
