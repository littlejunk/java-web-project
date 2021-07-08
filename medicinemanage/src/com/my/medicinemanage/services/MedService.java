package com.my.medicinemanage.services;

import java.util.List;

import com.my.medicinemanage.entity.Medicine;

public interface MedService {
public List<Medicine> findAll(String medId);
    
    public boolean delete(String medId);
    
    public boolean add(Medicine medicine);
    
    public boolean update(Medicine medicine);
    
    public List<Medicine> findNotuse() ;
    
    public boolean delNotuse(String[] medIds);
    
    public List<Medicine> findByKey(String key);
}
