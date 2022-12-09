package com.example.repos;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //this class provides the mechanism for storage ,retrieval, search, update and delete operation on objects.
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmpName(String empName);
    Employee findByEmpEmail(String empEmail);
    Employee findByEmpPhoneNum(String empPhoneNum);

}
