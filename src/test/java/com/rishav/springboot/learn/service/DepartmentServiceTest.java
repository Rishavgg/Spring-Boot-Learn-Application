package com.rishav.springboot.learn.service;

import com.rishav.springboot.learn.entity.DepartmentEntity;
import com.rishav.springboot.learn.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        DepartmentEntity department =
                DepartmentEntity.builder().departmentName("IT")
                        .departmentCode("IT-06")
                        .departmentAddress("Down Floor")
                        .departmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data bases on valid Department Name")
//    @Disabled // disable the test case with this annotation
    public void WhenValidDepartmentName_thenDepartmentShouldFound() {
//        DepartmentEntity department =
//                DepartmentEntity.builder().departmentName("IT")
//                        .departmentCode("IT-06")
//                        .departmentAddress("Down Floor")
//                        .departmentId(1L)
//                        .build();
//        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
        String departmentName = "IT";
        DepartmentEntity found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }

}