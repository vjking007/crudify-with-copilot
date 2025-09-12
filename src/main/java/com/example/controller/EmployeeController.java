package com.example.controller;

import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;
import com.example.service.Employeeservice;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final Employeeservice employeeservice;

    public EmployeeController(Employeeservice employeeservice) {
        this.employeeservice = employeeservice;
    }

    // Create a new employee and add validation
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeservice.add(employeeRequest), HttpStatus.CREATED);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return new ResponseEntity<>(employeeservice.getAllEmployees(), HttpStatus.OK);
    }

    //Get employee by id with EmployeeResponse DTO.
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeservice.getEmployeeById(id), HttpStatus.OK);
    }

    //delete employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeservice.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeservice.updateEmployeeById(id, employeeRequest), HttpStatus.OK);
    }
}
