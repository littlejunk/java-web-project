package dao;

import java.util.List;

import entity.Student;


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
