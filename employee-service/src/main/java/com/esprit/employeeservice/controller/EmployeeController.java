package com.esprit.employeeservice.controller;

import com.esprit.employeeservice.domain.Employee;
import com.esprit.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/{idBank}")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee, @PathVariable String idBank) throws ResourceNotFoundException {
        Employee emp = employeeService.saveEmployee(employee, idBank);
        return ResponseEntity.ok(emp);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
        Employee emp = employeeService.updateEmployee(employee);
        return ResponseEntity.ok().body(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        ResponseEntity responseEntity;
        Employee employee = employeeService.getEmployeeById(id);
        if (!id.equals(null))

        {
            employeeService.deleteEmployee(employee);

            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.badRequest().body("echec suppression");
        }

        return responseEntity;

    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> findEmployeeById(@PathVariable("id") String id) {

        if (!id.equals(null)) {
            Employee employee=employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/byEmail")
    ResponseEntity<Employee> findEmployeeByEmail(@RequestParam String email) {

        if (!email.equals(null)){
            Employee employee=employeeService.getEmployeeByEmail(email);
            return ResponseEntity.ok(employee);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping()
    ResponseEntity<List<Employee>> findAllEmployees() {

            List<Employee> employees = employeeService.getAllEmployees();
            if (!employees.isEmpty()) {
                return ResponseEntity.ok(employees);
            }

        return ResponseEntity.notFound().build();

    }
}
