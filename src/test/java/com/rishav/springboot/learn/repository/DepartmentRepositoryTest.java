package com.rishav.springboot.learn.repository;

import com.rishav.springboot.learn.entity.DepartmentEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Allows for interactions with the underlying JPA provider in test environment
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
       DepartmentEntity department = DepartmentEntity.builder()
                .departmentName("Bavra House")
                .departmentCode("Bavra@123")
                .departmentAddress("Bavra city")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        DepartmentEntity department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Bavra House");
    }
}