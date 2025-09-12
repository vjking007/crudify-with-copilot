package com.example.entity;

//Generate a class Employee with fields id, name, dept. Use id as emp_id, name as emp_name and dept as emp_dept. Use table name as employees.
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    // Use id as emp_id, name as emp_name and dept as emp_dept.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_dept")
    private String dept;
}
