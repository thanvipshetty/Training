package com.example.repos;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //this class provides the mechanism for storage ,retrieval, search, update and delete operation on objects.
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByName(String empName);
    Employee findByempName(String empName);
    Employee findByEmail(String empEmail);
    Employee findByPhone(String empPhoneNum);

}
