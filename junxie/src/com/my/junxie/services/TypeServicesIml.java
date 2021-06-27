package com.my.junxie.services;

import java.util.List;

import com.my.junxie.dao.TypeDao;
import com.my.junxie.dao.TypeDaoIml;
import com.my.junxie.entity.WeaponType;

public class TypeServicesIml implements TypeServices{
    
	TypeDao td = new TypeDaoIml();
	@Override
	public List<WeaponType> findAll(String typeId) {
		// TODO Auto-generated method stub
		return td.findAll(typeId);
	}

	@Override
	public boolean delete(int typeId) {
		// TODO Auto-generated method stub
		return td.delete(typeId);
	}

	@Override
	public boolean update(WeaponType weaponType) {
		// TODO Auto-generated method stub
		return td.update(weaponType);
	}

	@Override
	public boolean add(WeaponType weaponType) {
		// TODO Auto-generated method stub
		return td.add(weaponType);
	}

	@Override
	public List<WeaponType> findInUse() {
		// TODO Auto-generated method stub
		return td.findInUse();
	}
   
}
