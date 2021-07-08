package com.my.medicinemanage.dao;

import java.util.List;

import com.my.medicinemanage.entity.Medicine;

public interface MedDao {
	public List<Medicine> findAll(String medId);
    
    public boolean delete(String medId);
    
    public boolean add(Medicine medicine);
    
    public boolean update(Medicine medicine);
    
    public List<Medicine> findByKey(String key);
}
