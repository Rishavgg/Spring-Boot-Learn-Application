package com.rishav.springboot.learn.controller;

import com.rishav.springboot.learn.entity.DepartmentEntity;
import com.rishav.springboot.learn.error.DepartmentIdNotFound;
import com.rishav.springboot.learn.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Routing purpose get post
@RestController
public class MainController {

    //telling spring that departmentService obj I want from you , this will wire the particular obj to the reference that we have just created
//    @Autowired
    private DepartmentService departmentService;

    public MainController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    Logger LOGGER = LoggerFactory.getLogger(MainController.class);


    // whatever json we will be passing get that particular json and convert that particular json into department json
    @PostMapping("/departments")
    public DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity department) {
//        DepartmentService service = new DepartmentServiceImpl();
        LOGGER.info("Inside saveDepartment of MainController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<DepartmentEntity> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of MainController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public DepartmentEntity fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentIdNotFound {
        LOGGER.info("Inside fetchDepartmentById of MainController");
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public void deletingById(@PathVariable("id") Long id) {
        departmentService.deletingById(id);
        System.out.println("Deleted Successfully");
    }

    @PutMapping("/departments/{id}")
    public DepartmentEntity updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentEntity department){
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public DepartmentEntity fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }
}

//Logger comes with sl4j logging lib
// helpful for debugging purpose

