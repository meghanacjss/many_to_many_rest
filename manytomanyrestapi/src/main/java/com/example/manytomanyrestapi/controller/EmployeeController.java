package com.example.manytomanyrestapi.controller;

import com.example.manytomanyrestapi.entity.Employee;
import com.example.manytomanyrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")

    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping("/getEmployees/{empId}")
//    public List<Employee> getEmployee(@PathVariable int empId) {
//        return employeeService.getEmployeeDetails();
//    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployee() {
        return employeeService.getEmployeeDetails();
      //  return employeeService.findAll();
    }
        @DeleteMapping("/deleteEmployee/{empId}")
        public ResponseEntity removeEmployee(@PathVariable int empId){
            employeeService.deleteEmployee(empId);
            return new ResponseEntity(HttpStatus.OK);
        }

        @PutMapping("/{empId}/project/{projId}")
    public Employee assignProjectToEmployee(
            @PathVariable int empId,
            @PathVariable int projId
        ){
        return employeeService.assignProjectToEmployee(empId,projId);
        }
}
