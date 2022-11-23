package org.example;

import org.example.assign1.MatrixClass;
import org.example.assign2.Employees;
import org.example.assign2.SortingEmployees;
import org.example.assign3.InverseOfString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.hamcrest.MockitoHamcrest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class SortingTest {
//    @Mock
    private SortingEmployees sorting;
    @Test
    public void genderTesting(){
        SortingEmployees sorting = new SortingEmployees();
        List<Employees> emp = new ArrayList<Employees>();
        emp.add(new Employees("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employees("Celina","John",101, 27, "Female", "Product Development"));
        emp.add(new Employees("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employees("Prathika","Kumari",104, 27, "Female", "Account And Finance"));
        emp.add(new Employees("Rakesh","Krishna",107, 22, "Male", "HR"));
        emp.add(new Employees("Thanvi","Shetty",103,32, "Female", "HR"));
        emp.add(new Employees("Zakir","Hussain",106, 29, "Male", "Infrastructure"));
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
        List<Employees> emp = new ArrayList<>();
        emp.add(new Employees("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employees("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employees("Celina","John",101, 27, "Female", "Product Development"));
       // when(collection.sorting(emp)).thenReturn(emp);
        assertTrue(collection.sortingByFirstName(emp));
        //Assert.assertEquals(expected, collection.sorting(emp));
    }

    @Test
    public void sortingByLastName(){
        //final SortingEmployees collection = Mockito.mock(SortingEmployees.class);
        SortingEmployees sortingEmployees = new SortingEmployees();
        List<Employees> emp = new ArrayList<>();
        emp.add(new Employees("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employees("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employees("Celina","John",101, 27, "Female", "Product Development"));
        Employees expected = new Employees("Murali","Gupta",105, 28, "Male","HR");
        //Assert.assertSame(expected,sortingEmployees.sortingByLastname(emp));//assertEquals();
        Assert.assertEquals("Gupta",sortingEmployees.sortingByLastname(emp).getLastName());

    }

}
