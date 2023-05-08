package com.example.department.service;

import com.example.department.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);

    List<Department> getAllDepartments();
}
