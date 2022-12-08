package com.example.services;

import com.example.Exception.CustomException;
import com.example.Exception.EmployeeNotFoundException;
import com.example.entity.Employee;
import com.example.repos.EmployeeRepository;
import javax.persistence.UniqueConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //provides some business functionalities
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repo;

    //add new values to the database
    @Override
    public Employee saveEmployee(Employee employee) {
        Employee nameExists = findUserByName(employee.getEmpName());
        Employee emailExists = findUserByEmail(employee.getEmpEmail());
        Employee phoneExists = findUserByPhone(employee.getEmpPhoneNum());
            if( nameExists!=null){
                throw new CustomException("employee name is already present");
            }
            if(emailExists!=null){
                throw new CustomException("email is already present");
            }
            if(phoneExists!=null){
                 throw new CustomException("phonenumber is already is present");
            }else {
                return repo.save(employee);
            }
    }

    //fetch all the employee details from the database
    @Override
    public List<Employee> fetchEmployeeList() {
        return repo.findAll();
    }

    //get particular employee details from database if that id is present ,else throw exception
    @Override
    public Employee getByEmployeeId(int employeeId)  {
        Optional<Employee> optional = repo.findById(employeeId);
        Employee emp = null;
        if(optional.isPresent()){
            emp = optional.get();
        }
        else{
            throw new EmployeeNotFoundException(employeeId);
        }
        return emp;
    }


    //update the employee details for particular id if the input is not null and should not empty
    @Override
    public Employee updateEmployee(Employee employee, int employeeId) {
        return this.repo.findById(employeeId).map(emp -> {
            emp.setEmpName(employee.getEmpName());
            emp.setEmpPhoneNum(employee.getEmpPhoneNum());
            emp.setEmpEmail(employee.getEmpEmail());
            return repo.save(emp);
        }).orElseThrow(
                () -> new EmployeeNotFoundException(employeeId));


    }

    //delete particular employee details by id if present, else throw exception
    @Override
    public Boolean deleteEmployeeById(int employeeId) throws EmployeeNotFoundException {
        return this.repo.findById(employeeId).map(emp -> {
            this.repo.delete(emp);
            return true;
        }).orElseThrow(() -> new EmployeeNotFoundException(employeeId));

    }

    @Override
    public Employee findUserByName(String empName) {
        return repo.findByName(empName);
    }

    @Override
    public Employee findUserByEmail(String empEmail) {
        return repo.findByEmail(empEmail);
    }

    @Override
    public Employee findUserByPhone(String empPhoneNum) {
        return repo.findByPhone(empPhoneNum);
    }

}
