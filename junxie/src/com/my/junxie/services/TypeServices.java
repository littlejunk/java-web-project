package com.my.junxie.services;

import java.util.List;

import com.my.junxie.entity.WeaponType;

public interface TypeServices {
    public List<WeaponType> findAll(String typeId);
	
	public boolean delete(int typeId);
	
	public boolean update(WeaponType weaponType);
	
	public boolean add(WeaponType weaponType);
	
	public List<WeaponType> findInUse();
}
