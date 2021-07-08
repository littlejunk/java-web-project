package com.my.medicinemanage.dao;

import java.util.List;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;

import com.my.medicinemanage.entity.Manager;
import com.my.medicinemanage.entity.User;

public interface UserDao {
    public User login(String userName,String password);
    public Manager manlogin(String userName,String password);
    public List<User> findAll(String medId);
    public boolean update(User user);
    public boolean delete(int userId);
	public boolean add(User user);
}
