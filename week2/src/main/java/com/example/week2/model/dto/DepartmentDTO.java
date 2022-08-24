package com.example.week2.model.dto;

import com.example.week2.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String departmentId;
    private String dept_name;
    private String description;
    private Collection<Employee> employees;
}
