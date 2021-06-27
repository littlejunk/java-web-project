package com.my.junxie.dao;

import java.util.List;

import com.my.junxie.entity.WeaponType;



public interface TypeDao {

	public List<WeaponType> findAll(String typeId);
	
	public boolean delete(int typeId);
	
	public boolean update(WeaponType weaponType);
	
	public boolean add(WeaponType weaponType);
	
	public List<WeaponType> findInUse();
	
}
