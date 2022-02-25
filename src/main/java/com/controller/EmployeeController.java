package com.controller;

import com.dto.EmployeeDto;
import com.services.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.Constants.EMPLOYEE_SERVICE;
import static com.Routes.EMPLOYEES_API;
import static com.Routes.GET_EMPLOYEE_ID_API;
import static com.Routes.SAVE_EMPLOYEE_API;

@RestController
@RequestMapping(EMPLOYEES_API)
public class EmployeeController {

    @Resource(name = EMPLOYEE_SERVICE)
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(GET_EMPLOYEE_ID_API)
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(SAVE_EMPLOYEE_API)
    public EmployeeDto saveEmployee(final @RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @DeleteMapping(GET_EMPLOYEE_ID_API)
    public Boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
