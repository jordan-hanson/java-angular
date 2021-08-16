package com.observepoint.test.test.controllers;

import com.observepoint.test.test.models.Department;
import com.observepoint.test.test.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    /**
     * Given a complete Department object, create a new Department record
     * <br>Example: <a href="http://localhost:8080/departments/department"></a>
     *
     * @param newDepartment A complete new Department object
     * @return A location header with the URI to the newly created department and a status of CREATED
     * @see DepartmentService#save(Department) DepartmentService.save(newDepartment)
     */
    @PostMapping(value = "/department",
            consumes = "application/json")
    public ResponseEntity<?> addNewDepartment(
            @RequestBody
                    Department newDepartment)
    {
        // ids are not recognized by the Post method
        newDepartment.setId(0);
        newDepartment = depoService.save(newDepartment);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newDepartmentURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{departmentid}")
                .buildAndExpand(newDepartment.getId())
                .toUri();
        responseHeaders.setLocation(newDepartmentURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }
}
