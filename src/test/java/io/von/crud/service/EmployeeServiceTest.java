package io.von.crud.service;

import io.von.crud.model.Department;
import io.von.crud.model.Employee;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Before
    RestTemplate createRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Test
    void getEmployeeById() {

        String expected = "John";
        Employee employee = createRestTemplate().getForObject("http://localhost:8080/employees/1", Employee.class);
        String actual = employee.getName();
        System.out.println(actual);
        assertEquals(expected,actual);

    }



    @Test
    void saveEmployee() {

        String expected = "Halie";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Department department = new Department();
        department.setDeptName("ACT");
        department.setDeptDescription("Account");

        Employee employee = new Employee();
        employee.setName("Halie");
        employee.setSalary(1200);
        employee.setDepartment(department);

        HttpEntity<Employee> httpEntity = new HttpEntity<Employee>(employee,headers);
        Employee mary = createRestTemplate().postForObject("http://localhost:8080/addEmployee",httpEntity,Employee.class);
        String actual = mary.getName();
        assertEquals(expected,actual);


    }


}