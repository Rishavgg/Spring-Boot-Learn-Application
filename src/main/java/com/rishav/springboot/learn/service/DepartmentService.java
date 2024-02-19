package com.rishav.springboot.learn.service;

import com.rishav.springboot.learn.entity.DepartmentEntity;
import com.rishav.springboot.learn.error.DepartmentIdNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

// For Business logic from this service layer we will call data access layer or repository layer
//standard practice to create interface because one service can have multiple implementation as well
@Service
public interface DepartmentService {

    DepartmentEntity saveDepartment(DepartmentEntity department);

    List<DepartmentEntity> fetchDepartmentList();

    DepartmentEntity fetchDepartmentById(Long id) throws DepartmentIdNotFound;

    void deletingById(Long id);

    DepartmentEntity updateDepartment(Long id, DepartmentEntity department);

    DepartmentEntity fetchDepartmentByName(String name);
}
