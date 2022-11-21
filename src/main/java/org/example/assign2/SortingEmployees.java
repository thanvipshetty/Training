//Implement a program to sort Employees based on their first name
package org.example.assign2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingEmployees {
    public static void main(String[] args) {
        List<Employees> emp = new ArrayList<>();
        emp.add(new Employees("Thanvi","Shetty",103));
        emp.add(new Employees("Aaditya","Suvarna",102));
        emp.add(new Employees("Zakir","Sheikh",106));
        emp.add(new Employees("Murali","Gupta",105));
        emp.add(new Employees("Celina","John",101));
        emp.add(new Employees("Prathika","Kumari",104));
        System.out.println("Employee details before Sorting: ");
        emp.forEach(System.out::println);
        System.out.println("--------------------------------");
        System.out.println("Employee details After Sorting:");
        Collections.sort(emp,(o1,o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()));
        emp.forEach(System.out::println);
    }
}
