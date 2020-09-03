package io.von.crud.controller;

import io.von.crud.model.Department;
import io.von.crud.model.Employee;
import io.von.crud.service.DepartmentService;
import io.von.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class HrController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }



    @GetMapping("/departments")
    public List<Department> getAllDepartments(){return departmentService.getDepartments();}

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department){return departmentService.addDepartment(department);}

    @GetMapping("/departments/{deptId}")
    public Department getDepartmentById(@PathVariable("deptId") int deptId){
        return departmentService.getDepartmentById(deptId);
    }
}
