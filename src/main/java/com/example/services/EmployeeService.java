package com.example.services;

import com.example.Exception.EmployeeNotFoundException;
import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
      Employee saveEmployee(Employee employee);
      List<Employee> fetchEmployeeList();
      Employee getByEmployeeId(int employeeId) throws EmployeeNotFoundException;
      Employee updateEmployee(Employee employee, int employeeId);
      Boolean deleteEmployeeById(int employeeId) throws EmployeeNotFoundException;

}
