package com.example.service;

import com.example.dto.EmployeeRequest;
import com.example.dto.EmployeeResponse;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Employeeservice {

    //Inject EmployeeRepository
    private final EmployeeRepository employeeRepository;

    //Constructor injection for EmployeeRepository
    public Employeeservice(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Generate add employee method with EmployeeResponse as return type
    public EmployeeResponse add(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.name().stripTrailing());
        employee.setDept(request.department().stripTrailing());
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponse response = new EmployeeResponse(savedEmployee.getName(), savedEmployee.getDept());
        return response;
    }

    //Generate get all employees method with List of EmployeeResponse as return type
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> responses = employees.stream()
                .map(emp -> new EmployeeResponse(emp.getName(), emp.getDept()))
                .collect(Collectors.toList());
        return responses;
    }

    //Generate get employee by id method with EmployeeResponse as return type
    public EmployeeResponse getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeResponse response = new EmployeeResponse(employee.getName(), employee.getDept());
        return response;
    }

    //Generate delete employee by id method with void as return type
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    //Generate update employee by id method with EmployeeResponse as return type
    public EmployeeResponse updateEmployeeById(long id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(request.name().stripTrailing());
        employee.setDept(request.department().stripTrailing());
        Employee updatedEmployee = employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse(updatedEmployee.getName(), updatedEmployee.getDept());
        return response;
    }
}
