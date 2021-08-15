package com.observepoint.test.test.controllers;

import com.observepoint.test.test.models.Department;
import com.observepoint.test.test.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService depoService;

    //    Find All Departments
    //    http://localhost:8080/departments/departments
    @GetMapping(value = "/departments",
            produces = "application/json")
    public ResponseEntity<?> listAllDepartments()
    {
        List<Department> myDepartments = depoService.findAll();
        return new ResponseEntity<>(myDepartments, HttpStatus.OK);
    }
    //    Find Department By Id
    //    http://localhost:8080/departments/department/1
    @GetMapping(value = "/department/{departmentId}", produces = "applications/json")
    public ResponseEntity<?> getDepartmentById(@PathVariable long departmentId)
    {
        Department department = depoService.findDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
