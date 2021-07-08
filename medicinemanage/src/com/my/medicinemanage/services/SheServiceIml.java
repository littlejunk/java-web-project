package com.my.medicinemanage.services;

import java.util.List;

import com.my.medicinemanage.dao.DBhelper;
import com.my.medicinemanage.dao.SheDao;
import com.my.medicinemanage.dao.SheDaoIml;
import com.my.medicinemanage.entity.Shelve;

public class SheServiceIml implements SheService {
    SheDao sd = new SheDaoIml();
	@Override
	public List<Shelve> findAll(String sheId) {
		// TODO Auto-generated method stub
		return sd.findAll(sheId);
	}

	@Override
	public boolean delete(int sheId) {
		// TODO Auto-generated method stub
		return sd.delete(sheId);
	}

	@Override
	public boolean update(Shelve shelve) {
		// TODO Auto-generated method stub
		return sd.update(shelve);
	}

	@Override
	public boolean add(Shelve shelve) {
		// TODO Auto-generated method stub
		return sd.add(shelve);
	}

}
