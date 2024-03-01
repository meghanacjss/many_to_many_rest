package com.example.manytomanyrestapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="project")
public class Project {
    @Id
    @GeneratedValue
    private int projId;
    private String projName;
    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<>();
}
