package com.my.medicinemanage.entity;

public class Shelve {
    private int sheId;
    private int sheCap;
    private String sheName;
    private int sheCurrentCap;
	public Shelve() {
		super();
	}
	public Shelve(int sheId, int sheCap, String sheName) {
		super();
		this.sheId = sheId;
		this.sheCap = sheCap;
		this.sheName = sheName;
	}
	public int getSheId() {
		return sheId;
	}
	public void setSheId(int sheId) {
		this.sheId = sheId;
	}
	public int getSheCap() {
		return sheCap;
	}
	public void setSheCap(int sheCap) {
		this.sheCap = sheCap;
	}
	public String getSheName() {
		return sheName;
	}
	public void setSheName(String sheName) {
		this.sheName = sheName;
	}
	public int getSheCurrentCap() {
		return sheCurrentCap;
	}
	public void setSheCurrentCap(int sheCurrentCap) {
		this.sheCurrentCap = sheCurrentCap;
	}
	
    
}
