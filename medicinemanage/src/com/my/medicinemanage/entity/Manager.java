package com.my.medicinemanage.entity;

public class Manager {
	private int manId;
	private String maname;
	private String manpwd;

	public Manager(int manId, String maname, String manpwd) {
		super();
		this.manId = manId;
		this.maname = maname;
		this.manpwd = manpwd;
	}
	public Manager() {
		super();
	}
	public int getManId() {
		return manId;
	}
	public void setManId(int manId) {
		this.manId = manId;
	}
	public String getManame() {
		return maname;
	}
	public void setManame(String maname) {
		this.maname = maname;
	}
	public String getManpwd() {
		return manpwd;
	}
	public void setManpwd(String manpwd) {
		this.manpwd = manpwd;
	}

}
