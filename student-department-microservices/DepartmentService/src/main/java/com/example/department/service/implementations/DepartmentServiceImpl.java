package com.example.department.service.implementations;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import com.example.department.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        log.info("Inside the get department by id of the Department service");
        return departmentRepository.findById(departmentId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Department saveDepartment(Department department) {
        log.info("Inside the save department of Department service");
        return departmentRepository.save(department);
    }
}
