package com.example.services;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
      Employee saveEmployee(Employee employee);
      List<Employee> fetchEmployeeList();
      Employee getByEmployeeId(Long employeeId) throws Exception;
      Employee updateEmployee(Employee employee, Long employeeId);
      void deleteEmployeeById(Long employeeId);

}
