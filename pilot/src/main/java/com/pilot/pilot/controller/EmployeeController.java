package com.pilot.pilot.controller;

import com.pilot.pilot.exceptions.ResourceNotFoundException;
import com.pilot.pilot.models.Employee;
import com.pilot.pilot.repository.EmpRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmpRep empRep;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return empRep.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp)
    {
        return empRep.save(emp);
    }


    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {

        Employee emp=empRep.findById(id).orElseThrow(()-> new ResourceNotFoundException(("Employee Not Exist with Id"+id)));
    return ResponseEntity.ok(emp);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = empRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        empRep.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = empRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        empRep.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}


