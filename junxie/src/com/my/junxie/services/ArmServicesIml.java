package com.my.junxie.services;

import java.util.List;

import com.my.junxie.dao.ArmDao;
import com.my.junxie.dao.ArmDaoIml;
import com.my.junxie.entity.Arm;

public class ArmServicesIml implements ArmServices{
    
	ArmDao ad = new ArmDaoIml();
	@Override
	public List<Arm> findAll(String armId) {
		// TODO Auto-generated method stub
		return ad.findAll(armId);
	}

	@Override
	public boolean delete(String armId) {
		// TODO Auto-generated method stub
		return ad.delete(armId);
	}

	@Override
	public boolean add(Arm arm) {
		// TODO Auto-generated method stub
		return ad.add(arm);
	}

	@Override
	public boolean update(Arm arm) {
		// TODO Auto-generated method stub
		return ad.update(arm);
	}
     
}
