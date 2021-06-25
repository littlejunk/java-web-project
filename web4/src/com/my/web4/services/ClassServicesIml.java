package com.my.web4.services;

import java.util.List;

import com.my.web4.dao.ClassDao;
import com.my.web4.dao.ClassDaoIml;
import com.my.web4.entity.ClassInfo;

public class ClassServicesIml implements ClassServices{
    
	ClassDao cd = new ClassDaoIml();
	@Override
	public List<ClassInfo> findAll(String classId) {
		// TODO Auto-generated method stub
		return cd.findAll(classId);
	}

}
