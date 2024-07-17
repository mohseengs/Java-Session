package com.mohseen.department.service;

import com.mohseen.department.dto.DepartmentDTO;
import com.mohseen.department.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(DepartmentDTO departmentDTO);
    Department get(int id);
    List<Department> getAll();
}
