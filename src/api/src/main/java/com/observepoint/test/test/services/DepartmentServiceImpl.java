package com.observepoint.test.test.services;

import com.observepoint.test.test.exceptions.ResourceNotFoundException;
import com.observepoint.test.test.models.Department;
import com.observepoint.test.test.models.Role;
import com.observepoint.test.test.models.User;
import com.observepoint.test.test.models.UserRoles;
import com.observepoint.test.test.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value="departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository depoRepo;

    @Override
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();

        depoRepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Department findDepartmentById(long departmentId) throws
            ResourceNotFoundException
    {
        return depoRepo.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department Id" + departmentId + "Not Found"));
    }

    @Transactional
    @Override
    public Department save(Department newDepartment) {
        Department newDepartmentMade = new Department();

        if(newDepartment.getDepartmentid() != 0)
        {
            depoRepo.findById(newDepartment.getDepartmentid());
            newDepartmentMade.setDepartmentid(newDepartment.getDepartmentid());
        }
        newDepartmentMade.setName(newDepartment.getName());

        return depoRepo.save(newDepartmentMade);
    }
}
