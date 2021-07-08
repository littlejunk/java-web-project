package com.my.medicinemanage.services;

import java.util.List;

import com.my.medicinemanage.entity.Shelve;

public interface SheService {
	public List<Shelve> findAll(String sheId);

	public boolean delete(int sheId);

	public boolean update(Shelve shelve);

	public boolean add(Shelve shelve);
}
