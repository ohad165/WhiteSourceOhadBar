package com.services;

import com.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employee);
    boolean deleteEmployee(final Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(final Long employeeId);
}

