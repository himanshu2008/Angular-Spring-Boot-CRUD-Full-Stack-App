package com.project.ems.api;

import java.util.List;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.exception.EMSException;
import com.project.ems.service.EmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping(value = "/ems")
public class EmployeeAPI {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws EMSException {
        List<EmployeeDTO> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) throws EMSException {
        EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws EMSException {
        Long employeeId = employeeService.addEmployee(employeeDTO);
        String successMessage = environment.getProperty("EMSAPI.INSERT_SUCCESS") + employeeId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}