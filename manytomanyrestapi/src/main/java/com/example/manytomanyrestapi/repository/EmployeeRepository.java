package com.example.manytomanyrestapi.repository;

import com.example.manytomanyrestapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
  //  List<Employee> findAllByEmpId(int empId);
}
