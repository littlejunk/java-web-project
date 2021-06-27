package com.my.junxie.entity;

public class Arm {
    private WeaponType weaponType;
    private int armId;
    private String armName;
    private String bullet;
    private int shotRange;
    private int typeId;
	public Arm() {
		super();
	}
	public Arm( int armId, String armName, String bullet,
			int shotRange, int typeId) {
		super();
		this.armId = armId;
		this.armName = armName;
		this.bullet = bullet;
		this.shotRange = shotRange;
		this.typeId = typeId;
	}
	public WeaponType getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}
	public int getArmId() {
		return armId;
	}
	public void setArmId(int armId) {
		this.armId = armId;
	}
	public String getArmName() {
		return armName;
	}
	public void setArmName(String armName) {
		this.armName = armName;
	}
	public String getBullet() {
		return bullet;
	}
	public void setBullet(String bullet) {
		this.bullet = bullet;
	}
	public int getShotRange() {
		return shotRange;
	}
	public void setShotRange(int shotRange) {
		this.shotRange = shotRange;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
    
	
    
    
}
