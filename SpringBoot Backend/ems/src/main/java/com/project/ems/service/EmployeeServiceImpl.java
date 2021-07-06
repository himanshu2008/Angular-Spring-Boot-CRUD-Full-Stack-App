package com.project.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.entity.Employee;
import com.project.ems.exception.EMSException;
import com.project.ems.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO getEmployee(Long employeeId) throws EMSException {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = optional.orElseThrow(() -> new EMSException("Service.EMPLOYEE_NOT_FOUND"));
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmailId(employee.getEmailId());

        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() throws EMSException {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        employeeIterable.forEach(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeId(employee.getEmployeeId());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setEmailId(employee.getEmailId());
            employeeDTOs.add(employeeDTO);
        });
        if (employeeDTOs == null || employeeDTOs.isEmpty())
            throw new EMSException("Service.EMPLOYEES_NOT_FOUND");
        
        return employeeDTOs;
    }

    @Override
    public Long addEmployee(EmployeeDTO employeeDTO) throws EMSException {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmailId(employeeDTO.getEmailId());
        
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee.getEmployeeId();
    }
}