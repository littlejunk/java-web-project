package com.my.web4.services;

import java.util.List;

import com.my.web4.entity.ClassInfo;

public interface ClassServices {
     abstract public List<ClassInfo> findAll(String classId);
}
