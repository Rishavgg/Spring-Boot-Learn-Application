package com.rishav.springboot.learn.controller;

import com.rishav.springboot.learn.entity.DepartmentEntity;
import com.rishav.springboot.learn.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// we need to test our endpoint for controller

@WebMvcTest(MainController.class)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private DepartmentEntity department;

    @BeforeEach
    void setUp() {
        department = DepartmentEntity.builder()
                .departmentName("NewName")
                .departmentAddress("Rj")
                .departmentCode("RJ13")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        DepartmentEntity inputDepartment = DepartmentEntity.builder()
                .departmentName("NewName")
                .departmentAddress("Rj")
                .departmentCode("RJ13")
                .departmentId(1L)
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        // calling endpoint
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\t  \"departmentName\": \"NewName\",\n" +
                "\t\t\"departmentAddress\": \"Rj\",\n" +
                "\t\t\"departmentCode\": \"RJ13\"\n" +
                "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                        .andExpect(jsonPath("departmentName")
                                .value(department.getDepartmentName()));

    }
}