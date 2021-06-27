package com.my.junxie.services;

import java.util.List;

import com.my.junxie.entity.Arm;

public interface ArmServices {
     public List<Arm> findAll(String armId);
     
     public boolean delete(String armId);
     
     public boolean add(Arm arm);
     
     public boolean update(Arm arm);
}
