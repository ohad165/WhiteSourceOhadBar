package com.services;

import com.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginService {

    private final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private EmployeeService employeeService;

    public static final String USER_FOUND_LOG_MSG = "User:{}  ,Found !!!";

    public boolean isEmployeeValid(String userName, String password) {
        List<EmployeeDto> employeeList = employeeService.getAllEmployees();
        for(EmployeeDto dbEmployee : employeeList) {
            if(validateLogin(dbEmployee, userName, password)) {
                logger.info(USER_FOUND_LOG_MSG, userName);
                return true;
            }
        }
        return false;
    }

    public boolean validateLogin(EmployeeDto dbEmployee, String userName, String password) {
        return dbEmployee.getUserName().equals(userName)
                && dbEmployee.getUserPassword().equals(password);
    }
}
