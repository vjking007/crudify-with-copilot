package com.example.copilot.controller;

// Generate a REST controller with endpoints for all CRUD operations using EmployeeService. Use @RequestMapping("/api/v1/employees").
//Use @RestController and @Autowired annotations where necessary. Use ResponseEntity for responses.
// Use @PathVariable for id in endpoints and @RequestBody for Employee in create and update endpoints.
// Use appropriate HTTP status codes for each operation.
//Use Request as a EmployeeRequest DTO and Response as EmployeeResponse DTO.
// Use standard naming conventions for methods and variables.

import com.example.copilot.entity.EmployeeEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.copilot.service.EmployeeService;
import com.example.copilot.dto.EmployeeRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeeEntity>> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeEntity> employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeEntity createdEmployee = employeeService.createEmployee(employeeRequest);
        return ResponseEntity.status(201).body(createdEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<EmployeeEntity>> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        Optional<EmployeeEntity> updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
