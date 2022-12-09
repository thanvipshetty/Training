package com.example.services;

import com.example.Exception.EmployeeNotFoundException;
import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
      //to add new values to database
      Employee saveEmployee(Employee employee);
      // fetch all employee details from the database
      List<Employee> fetchEmployeeList();
      // fetch particular  id  detail of employee fom database else throw exception
      Employee getByEmployeeId(int employeeId);
      //update the details of employee by particular id present in database
      Employee updateEmployee(Employee employee, int employeeId);
      // delete an employee detail by particular id
      Boolean deleteEmployeeById(int employeeId) ;
      Employee findUserByEmpName(String empName);
//
      Employee findUserByEmpEmail(String empEmail);
//
      Employee findUserByEmpPhoneNum(String empPhoneNum);

}
