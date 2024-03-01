package com.example.manytomanyrestapi.service;

import com.example.manytomanyrestapi.entity.Employee;
import com.example.manytomanyrestapi.entity.Project;
import com.example.manytomanyrestapi.repository.EmployeeRepository;
import com.example.manytomanyrestapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public void saveEmployee (Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeDetails(){
     return  employeeRepository.findAll();
    }

    public void deleteEmployee(int empId){
        employeeRepository.deleteById(empId);
    }

    public Employee assignProjectToEmployee(int empId, int projId) {
        List<Project> projectlist = null;
        Employee employee = employeeRepository.findById(empId).get();
Project project = projectRepository.findById(projId).get();
 projectlist = employee.getProjects();
 projectlist.add(project);
 employee.setProjects(projectlist);
 return employeeRepository.save(employee);
    }
}
