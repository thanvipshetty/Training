package com.example;

import com.example.Exception.EmployeeNotFoundException;
import com.example.entity.Employee;
import com.example.repos.EmployeeRepository;
import com.example.services.EmployeeService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeService employeeService;
    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional
    public void saveEmployeeTest(){
        Employee employee = new Employee();
        employee.setEmpName("smiths");
        employee.setEmpPhoneNum("7845672345");
        employee.setEmpEmail("smith@gmail.com");
        assertNotNull(employeeService.saveEmployee(employee));
       // when(employeeRepository.save(employee)).thenReturn(employee);
    }

    @Test
    public void fetchEmployeeListTest(){
        assertEquals(8,employeeService.fetchEmployeeList().size());
        List<Employee> employee=employeeService.fetchEmployeeList();
		for (Employee employee2 : employee) {
			System.out.println(employee2);
		}
    }

    @Test
    public void getByEmployeeIdTest() throws EmployeeNotFoundException {
        Employee getid = employeeService.getByEmployeeId(1);
        Employee employee = new Employee(1,"saavan","8934562389","saavan@gmail.com");
        assertEquals("saavan",getid.getEmpName());
        assertEquals(employee,getid);
        assertNotNull(getid);
        System.out.println(getid);

    }
//    @Test
//    public void findById() throws EmployeeNotFoundException {
//        Employee entity =  new Employee(4,"drithi","7845672367","drithis@gmail.com");
//
//        int key = 4;
//        when(employeeService.getByEmployeeId(key)).thenReturn(entity);
//       // when(employeeRepository.findById(key)).thenReturn(Optional.of(entity));
//
//        Employee employee = employeeService.getByEmployeeId(key);
//        assertEquals(entity,employee);
//        System.out.println(employee);
//       // assertEquals(true,employee.isPresent());
//    }

    @Test
    @Transactional
    public void updateEmployeeTest(){
        Employee e=new Employee();
        e.setEmpName("xxx");
        Employee emp = employeeService.updateEmployee(e,8);
        assertEquals(e.getEmpName(), emp.getEmpName());
        Employee emp1 = new Employee(8,"xxx","6734562378","krithisharma@gmail.com");
        assertEquals(emp1,emp);

        Employee employee = new Employee();
        employee.setEmpName("");
        Employee employee1 = employeeService.updateEmployee(employee,4);
        assertNotEquals(employee.getEmpName(), employee1.getEmpName());
        // when(employeeRepository.save(e)).thenReturn(e);
        // when(employeeRepository.findById(e.getEmpId())).thenReturn(Optional.of(e));
    }

    @Test
    @Transactional
    public void deleteEmployeeById() throws EmployeeNotFoundException {
//        when(employeeRepository.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
        Boolean result = employeeService.deleteEmployeeById(1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(Optional.empty(),employeeRepository.findById(1));
      //  verify(employeeRepository).deleteById(employee.getEmpId());

    }
}
