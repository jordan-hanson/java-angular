package com.observepoint.test.test.services;

import com.observepoint.test.test.models.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findDepartmentById(long departmentId);

    Department save(Department newDepartment);
}
