package com.rishav.springboot.learn.repository;

import com.rishav.springboot.learn.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// responsible for database operating this will interact with database
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    public DepartmentEntity findByDepartmentName(String departmentName);

    public DepartmentEntity findByDepartmentNameIgnoreCase(String departmentName);

}

// Validation that i want my department name should always be available without that should be invalid (bad request)
// we can use hibernate validation