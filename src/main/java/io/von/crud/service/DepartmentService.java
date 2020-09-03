package io.von.crud.service;

import io.von.crud.model.Department;
import io.von.crud.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department){ return departmentRepository.save(department);}

    public Department getDepartmentById(int deptId){
        return departmentRepository.findById(deptId).get();
    }
}
