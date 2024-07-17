package com.mohseen.department.controller;

import com.mohseen.department.dto.DepartmentDTO;
import com.mohseen.department.entity.Department;
import com.mohseen.department.service.DepartmentService;
import com.mohseen.department.utils.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentRequest) {
        Department savedDepartment = departmentService.save(departmentRequest);
        DepartmentDTO departmentResponse = DepartmentMapper.toDTO(savedDepartment);

        return ResponseEntity.ok(departmentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable int id) {
        Department department = departmentService.get(id);
        DepartmentDTO departmentResponse = DepartmentMapper.toDTO(department);
        return ResponseEntity.ok(departmentResponse);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<Department> departments = departmentService.getAll();
        List<DepartmentDTO> departmentsResponse = departments
                .stream()
                .map(DepartmentMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(departmentsResponse);
    }
}
