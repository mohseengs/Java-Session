package com.mohseen.department.service;

import com.mohseen.department.dto.DepartmentDTO;
import com.mohseen.department.entity.Department;
import com.mohseen.department.repository.DepartmentRepository;
import com.mohseen.department.utils.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    final DepartmentRepository departmentRepository;

    @Autowired
    DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.toEntity(departmentDTO);
        return departmentRepository.save(department);
    }

    @Override
    public Department get(int id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }
}
