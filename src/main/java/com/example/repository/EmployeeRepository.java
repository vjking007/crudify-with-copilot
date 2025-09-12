package com.example.repository;

//make it as repository class
//annotate it with @Repository
//this class will be used to interact with the database for Employee entity
//it will have methods like save, findById, findAll, deleteById
// make interface instead of class
// extend JpaRepository<Employee, Long>
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
