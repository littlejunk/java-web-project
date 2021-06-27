package com.my.junxie.entity;

public class WeaponType {
     private int typeId;
     private String typeName;
     private int isUse;
	 public WeaponType(int typeId, String typeName, int isUse) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.isUse = isUse;
	 }
	 public WeaponType() {
		super();
	 }
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getIsUse() {
		return isUse;
	}
	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}
     
	
}
