package com.my.medicinemanage.dao;

import java.util.List;

import com.my.medicinemanage.entity.Shelve;

public interface SheDao {
	public List<Shelve> findAll(String sheId);

	public boolean delete(int sheId);

	public boolean update(Shelve shelve);

	public boolean add(Shelve shelve);


}
