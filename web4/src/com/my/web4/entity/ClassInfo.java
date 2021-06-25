package com.my.web4.entity;

public class ClassInfo {
	private int classId;
	private String className;
	public int getClassId() {
		return classId;
	}
	
	
	public ClassInfo() {
		super();
	}


	public ClassInfo(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	

}
