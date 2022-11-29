package com.example.services;

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
    public Employee getByEmployeeId(Long employeeId) throws Exception {
        Optional<Employee> optional = repo.findById(employeeId);
        Employee emp = null;
        if(optional.isPresent()){
            emp = optional.get();
        }
        else{
            throw new Exception("Employee not found for id " + employeeId);
        }
        return emp;
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId) {
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
    public void deleteEmployeeById(Long employeeId) {
        repo.deleteById(employeeId);

    }

}
