package com.mohseen.department.utils;

import com.mohseen.department.dto.DepartmentDTO;
import com.mohseen.department.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            return null;
        }

        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        return department;
    }

    public static DepartmentDTO toDTO(Department department) {
        if (department == null) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getName());
        return departmentDTO;
    }
}
