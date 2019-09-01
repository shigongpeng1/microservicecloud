package com.chrishi.springcloud.dao;

import com.chrishi.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao2 {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
