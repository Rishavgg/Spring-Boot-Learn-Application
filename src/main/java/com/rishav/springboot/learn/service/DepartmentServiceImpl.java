package com.rishav.springboot.learn.service;

import com.rishav.springboot.learn.entity.DepartmentEntity;
import com.rishav.springboot.learn.error.DepartmentIdNotFound;
import com.rishav.springboot.learn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<DepartmentEntity> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity fetchDepartmentById(Long id) throws DepartmentIdNotFound {
//        return departmentRepository.findById(id).get();
        Optional<DepartmentEntity> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentIdNotFound("Department Id Not Found");
        }
        return department.get();
    }


    @Override
    public void deletingById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentEntity updateDepartment(Long id, DepartmentEntity department) {
        DepartmentEntity depDB = departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public DepartmentEntity fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
