package entity;

public class Student {
	private int stuId;
	private String stuName;
	private int stuAge;
	private String stuSex;
	private int classId;

	/*无参构造*/
	public Student() {
		super();
	}

	/*有参构造*/
	public Student(int stuId, String stuName, int stuAge, String stuSex, int classId) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuSex = stuSex;
		this.classId = classId;
	}

	/*封装get/set方法*/
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
}
