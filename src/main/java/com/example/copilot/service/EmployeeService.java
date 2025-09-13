package com.example.copilot.service;

//Generate a service with methods: createEmployee, getEmployeeById, getAllEmployees, updateEmployee, deleteEmployee. Use EmployeeRepository for database operations. Use Employee entity for data representation. Handle exceptions appropriately. Use Spring's @Service annotation for the service class
// Use constructor injection for EmployeeRepository
//Use EmployeeRequest as a parameter for createEmployee and updateEmployee methods

import org.springframework.stereotype.Service;
import com.example.copilot.repository.EmployeeRepository;
import com.example.copilot.entity.EmployeeEntity;
import com.example.copilot.dto.EmployeeRequest;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(employeeRequest.name());
        employee.setDept(employeeRequest.dept());
        return employeeRepository.save(employee);
    }

    public Optional<EmployeeEntity> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> updateEmployee(Long id, EmployeeRequest employeeRequest) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeRequest.name());
            employee.setDept(employeeRequest.dept());
            return employeeRepository.save(employee);
        });
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
