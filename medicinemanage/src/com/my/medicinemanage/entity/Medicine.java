package com.my.medicinemanage.entity;

public class Medicine implements Comparable<Medicine> {
	private int medId;
	private String medName;
	private float medPrice;
	private int medNum;
	private String production;
	private String sheLife;
	private int sheId;
	private Shelve shelve;
	public Medicine() {
		super();
	}
	public Medicine(int medId, String medName, float medPrice, int medNum,
			String production, String sheLife, int sheId) {
		super();
		this.medId = medId;
		this.medName = medName;
		this.medPrice = medPrice;
		this.medNum = medNum;
		this.production = production;
		this.sheLife = sheLife;
		this.sheId = sheId;
	}
	public int getMedId() {
		return medId;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public float getMedPrice() {
		return medPrice;
	}
	public void setMedPrice(float medPrice) {
		this.medPrice = medPrice;
	}
	public int getMedNum() {
		return medNum;
	}
	public void setMedNum(int medNum) {
		this.medNum = medNum;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getSheLife() {
		return sheLife;
	}
	public void setSheLife(String sheLife) {
		this.sheLife = sheLife;
	}
	public int getSheId() {
		return sheId;
	}
	public void setSheId(int sheId) {
		this.sheId = sheId;
	}
	public Shelve getShelve() {
		return shelve;
	}
	public void setShelve(Shelve shelve) {
		this.shelve = shelve;
	}
	@Override
	public int compareTo(Medicine o) {
		// TODO Auto-generated method stub
		if(this.medId>o.getMedId()){
			return 1;
		}else if(this.medId==o.getMedId()) {
			return 0;
		}else {
			return -1;
		}
		
	}
    



}
