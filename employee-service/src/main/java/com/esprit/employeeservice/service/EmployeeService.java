package com.esprit.employeeservice.service;

import com.esprit.employeeservice.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee (Employee employee, String idBank);

    Employee updateEmployee (Employee employee);

    void deleteEmployee (Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    Employee getEmployeeByEmail(String email);
}
