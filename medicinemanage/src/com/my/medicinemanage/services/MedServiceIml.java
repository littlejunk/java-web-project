package com.my.medicinemanage.services;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ch.qos.cal10n.LocaleData;

import com.my.medicinemanage.dao.MedDao;
import com.my.medicinemanage.dao.MedDaoIml;
import com.my.medicinemanage.entity.Medicine;

public class MedServiceIml implements MedService{
    private MedDao md = new MedDaoIml();
	@Override
	public List<Medicine> findAll(String medId) {
		// TODO Auto-generated method stub
		return md.findAll(medId);
	}

	@Override
	public boolean delete(String medId) {
		// TODO Auto-generated method stub
		return md.delete(medId);
	}

	@Override
	public boolean add(Medicine medicine) {
		// TODO Auto-generated method stub
		return md.add(medicine);
	}

	@Override
	public boolean update(Medicine medicine) {
		// TODO Auto-generated method stub
		return md.update(medicine);
	}

	@Override
	public List<Medicine> findNotuse() {
		// TODO Auto-generated method stub
		List<Medicine> list = md.findAll(null);
		List<Medicine> list1 = new ArrayList<Medicine>();
		long betWeen;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<list.size();i++){
	        Date staDate = null;
			try {
				staDate = sdf.parse(list.get(i).getSheLife());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Date nowDate = new Date(System.currentTimeMillis());
	        betWeen = (staDate.getTime()-nowDate.getTime())/(60*60*24*1000);
	        if(betWeen<=90){
	        	list1.add(list.get(i));
	        }
		}
		return list1;
	}

	@Override
	public boolean delNotuse(String[] medIds) {
		for(int i=0;i<medIds.length;i++){
			if(!delete(medIds[i])){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Medicine> findByKey(String key) {
		return md.findByKey(key);
	}
	
	

}
