package com.example.copilot.repository;

//Generate a Spring Data JPA repository interface for Employee entity.
// The interface should extend JpaRepository. The primary key type of Employee is Long.
// The repository should be annotated with @Repository.
//add import org.springframework.data.jpa.repository.JpaRepository;
//add import org.springframework.stereotype.Repository;

import com.example.copilot.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
