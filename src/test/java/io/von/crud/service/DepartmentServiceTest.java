package io.von.crud.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.von.crud.model.Department;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    @Test
    void getDepartmentsById() {

        String expected = "ACT";

        RestTemplate restTemplate = new RestTemplate();
        Department department = restTemplate.getForObject("http://localhost:8080/departments/1",Department.class);

        String actual = department.getDeptName();
        System.out.println(actual);

        assertEquals(expected,actual);

    }

    @Test
    void addDepartment() throws JSONException {

        String expected = "IT";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Department department = new Department();
        department.setDeptName("IT");
        department.setDeptDescription("Information Technology");

        HttpEntity<Department> postRequest = new HttpEntity<Department>(department, headers);

        Department dept = restTemplate.postForObject("http://localhost:8080/addDepartment",postRequest, Department.class);
        String actual = dept.getDeptName();
        System.out.println(actual);

        assertEquals(expected,actual);
    }


}