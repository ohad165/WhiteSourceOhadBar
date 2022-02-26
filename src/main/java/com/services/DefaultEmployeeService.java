package com.services;

import com.EmployeeRepository;
import com.data.Employee;
import com.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.Constants.EMPLOYEE_NOT_FOUND_MSG;
import static com.Constants.EMPLOYEE_SERVICE;


@Service(EMPLOYEE_SERVICE)
public class DefaultEmployeeService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee customerModel = populateEmployeeEntity(employeeDto);
        return populateEmployeesData(employeeRepository.save(customerModel));
    }

    @Override
    public boolean deleteEmployee(Long customerId) {
        employeeRepository.deleteById(customerId);
        return true;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = new ArrayList<>();
        Iterable<Employee> employeeList = employeeRepository.findAll();
        employeeList.forEach(employee -> {
            employees.add(populateEmployeesData(employee));
        });
        return employees;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return populateEmployeesData(employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(EMPLOYEE_NOT_FOUND_MSG)));
    }

    private EmployeeDto populateEmployeesData(final Employee employee) {
        EmployeeDto customerData = new EmployeeDto();
        customerData.setId(employee.getId());
        customerData.setUserName(employee.getUserName());
        customerData.setUserPassword(employee.getUserPassword());
        return customerData;
    }

    private Employee populateEmployeeEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setUserName(employeeDto.getUserName());
        employee.setUserPassword(employeeDto.getUserPassword());
        return employee;
    }
}