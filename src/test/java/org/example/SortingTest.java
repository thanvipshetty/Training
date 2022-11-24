package org.example;

import junit.framework.Assert;
import org.example.assign2.Employee;
import org.example.assign2.SortingEmployees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static org.junit.Assert.*;
//import org.junit.Assert.AssertThat;

import static org.example.assign2.SortingEmployees.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SortingTest {
//    @Mock
    private SortingEmployees sorting;
    @Test
    public void genderTesting(){
        SortingEmployees sorting = new SortingEmployees();
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employee("Celina","John",101, 27, "Female", "Product Development"));
        emp.add(new Employee("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employee("Prathika","Kumari",104, 27, "Female", "Account And Finance"));
        emp.add(new Employee("Rakesh","Krishna",107, 22, "Male", "HR"));
        emp.add(new Employee("Thanvi","Shetty",103,32, "Female", "HR"));
        emp.add(new Employee("Zakir","Hussain",106, 29, "Male", "Infrastructure"));
        Map<String, Long> result = new HashMap<String,Long>();
        result.put("Male", 4L);
        result.put("Female",3L);
        assertEquals(result,sorting.genderCount(emp));
        //assertEquals(emp,sorting.sorting(emp));
        //when(sorting.genderCount(emp)).thenReturn("ok");

    }
    @Test
    public void sortingByFirstNameTesting(){
        //final SortingEmployees collection = Mockito.mock(SortingEmployees.class);
        SortingEmployees collection = new SortingEmployees();
//        List<Employees> expected = new ArrayList<Employees>();
//        expected.add(new Employees("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
//        expected.add(new Employees("Celina","John",101, 27, "Female", "Product Development"));
//        expected.add(new Employees("Murali","Gupta",105, 28, "Male","HR"));
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employee("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employee("Celina","John",101, 27, "Female", "Product Development"));
       // when(collection.sorting(emp)).thenReturn(emp);
        assertTrue(collection.sortingByFirstName(emp));
        //Assert.assertEquals(expected, collection.sorting(emp));
    }

    @Test
    public void sortingByLastName(){
        //final SortingEmployees sortingEmployee = Mockito.mock(SortingEmployees.class);
        SortingEmployees sortingEmployees = new SortingEmployees();
        //SortingEmployees sortingEmployees = mock(SortingEmployees.class);
        //Employees employees = mock(Employees.class);
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employee("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employee("Celina","John",101, 27, "Female", "Product Development"));
        Employee expected = new Employee("Murali","Gupta",105, 28, "Male","HR");
        Assert.assertEquals("Gupta",sortingEmployees.sortingByLastname(emp).getLastName());
//        doNothing().when(sortingEmployees).sortingByLastname(any());
//        sortingEmployees.sortingByLastname(emp);
//        verify(sortingEmployees,times(1)).sortingByLastname(emp);
//        doCallRealMethod().when(sortingEmployees).sortingByLastname(anyList());
    }
    @Test
    public void empCountInDept(){
        SortingEmployees sortingEmployees = new SortingEmployees();
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employee("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employee("Celina","John",101, 27, "Female", "Sales And Marketing"));
        Map<String,Long> map = new HashMap<String,Long>();
        map.put("HR",1L);
        map.put("Sales And Marketing",2L);
        assertEquals(map.entrySet(), sortingEmployees.empCountInDept(emp));
    }
    @Test
    public void youngestMaleInDept(){
        SortingEmployees sortingEmployees= mock(SortingEmployees.class);
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employee("Aaditya","Murma",102, 25, "Male", "HR"));
        emp.add(new Employee("Celina","John",101, 27, "Female", "Sales And Marketing"));
        Employee employee = mock(Employee.class);
        employee.setFirstName("Aaditya");
        employee.setLastName("Murma");
        employee.setEmpId(102);
        employee.setAge(25);
        employee.setGender("Male");
        employee.setDepartment("HR");
        Assert.assertEquals("Aaditya",sortingEmployees.youngestMaleInHRDept(emp).getFirstName());
       // when(sortingEmployees.youngestMaleInHRDept(emp)).thenReturn(employee);
    }
    @Test
    public void empInEachDept(){
        SortingEmployees sortingEmployees = new SortingEmployees();
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Thanvi","Shetty",103,32, "Female", "HR"));
        emp.add(new Employee("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employee("Zakir","Hussain",106, 29, "Male", "Infrastructure"));
        emp.add(new Employee("Murali","Gupta",105, 28, "Male","HR"));
        List<Employee> emp1 = new ArrayList<>();
        emp1.add(new Employee("Thanvi","Shetty",103,32, "Female", "HR"));
        emp1.add(new Employee("Murali","Gupta",105, 28, "Male","HR"));
        assertEquals(true,sortingEmployees.empInEachDept(emp));
    }
}
