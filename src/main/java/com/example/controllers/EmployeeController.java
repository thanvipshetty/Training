package com.example.controllers;

import com.example.Exception.EmployeeNotFoundException;
import com.example.entity.Employee;
import com.example.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController  {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        logger.trace("save method Accessed");
        return new ResponseEntity(this.employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAllEmployee() {
        logger.trace("find all method Accessed");
        return new ResponseEntity<List<Employee>>(this.employeeService.fetchEmployeeList(),HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity findById(@PathVariable("id") int empId) {
        logger.trace("find by id method Accessed");
        return new ResponseEntity(this.employeeService.getByEmployeeId(empId), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateById( @RequestBody Employee employee,@PathVariable("id") int empId){
        logger.trace("update by id method Accessed");
        return new ResponseEntity<>(this.employeeService.updateEmployee(employee,empId),HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int empId) throws EmployeeNotFoundException {
        logger.trace("delete by id method is Accessed");
        if (this.employeeService.deleteEmployeeById(empId)) {
            return ResponseEntity.ok().body("Deleted Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
