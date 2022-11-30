package com.example.services;

import com.example.Exception.EmployeeNotFoundException;
import com.example.entity.Employee;
import com.example.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return repo.findAll();
    }

    @Override
    public Employee getByEmployeeId(int employeeId) throws EmployeeNotFoundException {
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

    @Override
    public Employee updateEmployee(Employee employee, int employeeId) {
        Employee depDB = repo.findById(employeeId).get();

        if (Objects.nonNull(employee.getEmpName()) && !"".equalsIgnoreCase(employee.getEmpName())) {
            depDB.setEmpName(employee.getEmpName());
        }

        if (Objects.nonNull(employee.getEmpPhoneNum()) && !"".equalsIgnoreCase(employee.getEmpPhoneNum())) {
            depDB.setEmpPhoneNum(employee.getEmpPhoneNum());
        }

        if (Objects.nonNull(employee.getEmpEmail()) && !"".equalsIgnoreCase(employee.getEmpEmail())) {
            depDB.setEmpEmail(employee.getEmpEmail());
        }

        return repo.save(depDB);

    }

    @Override
    public Boolean deleteEmployeeById(int employeeId) throws EmployeeNotFoundException {
        return this.repo.findById(employeeId).map(emp -> {
            this.repo.delete(emp);
            return true;
        }).orElseThrow(() -> new EmployeeNotFoundException(employeeId));

    }

}
