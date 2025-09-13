package com.example.copilot.entity;

// Generate a JPA entity named Employee with fields: id (int), name (String), dept (String). use column names: emp_id, emp_name, emp_dept respectively. use lombok annotations for getters, setters, constructors and toString method. use jakarta.persistence package for JPA annotations.
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_dept")
    private String dept;
}
