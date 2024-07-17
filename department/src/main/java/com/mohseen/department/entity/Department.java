package com.mohseen.department.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue
    int id;
    String name;
}
