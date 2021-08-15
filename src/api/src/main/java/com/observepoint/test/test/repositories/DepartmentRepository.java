package com.observepoint.test.test.repositories;

import com.observepoint.test.test.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
