package com.services;

import com.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private EmployeeService employeeService;

    public boolean validateEmployee(String userName, String password) {
        return  employeeService
                .getAllEmployees().stream()
                .anyMatch(dbEmployee -> validateLogin(dbEmployee, userName, password));
    }

    public boolean validateLogin(EmployeeDto dbEmployee, String userName, String password) {
        return dbEmployee.getUserName().equals(userName)
                && dbEmployee.getUserPassword().equals(password);
    }
}
