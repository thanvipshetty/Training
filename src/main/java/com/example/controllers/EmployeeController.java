package com.example.controllers;

import com.example.Exception.EmployeeNotFoundException;
import com.example.entity.Employee;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity(this.employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAllEmployee() {
        return new ResponseEntity<List<Employee>>(this.employeeService.fetchEmployeeList(),HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") int empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(this.employeeService.getByEmployeeId(empId),HttpStatus.OK);
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateById( @RequestBody Employee employee,@PathVariable("id") int empId){
        return new ResponseEntity<>(this.employeeService.updateEmployee(employee,empId),HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int empId) throws EmployeeNotFoundException {
        if (this.employeeService.deleteEmployeeById(empId)) {
            return ResponseEntity.ok().body("Deleted Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
