package com.my.web4.dao;

import java.util.List;

import com.my.web4.entity.ClassInfo;

public interface ClassDao {
    abstract public List<ClassInfo> findAll(String classId);
}
