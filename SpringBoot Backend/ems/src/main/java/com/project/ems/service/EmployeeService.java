package com.project.ems.service;

import java.util.List;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.exception.EMSException;

public interface EmployeeService {
    public EmployeeDTO getEmployee(Long employeeId) throws EMSException;
    public List<EmployeeDTO> getAllEmployees() throws EMSException;
}