//Implement a program to sort Employees based on their first name
package org.example.assign2;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingEmployees {
    public static void main(String[] args) {
        List<Employees> emp = new ArrayList<Employees>();
        emp.add(new Employees("Thanvi","Shetty",103,32, "Female", "HR"));
        emp.add(new Employees("Aaditya","Murma",102, 25, "Male", "Sales And Marketing"));
        emp.add(new Employees("Zakir","Hussain",106, 29, "Male", "Infrastructure"));
        emp.add(new Employees("Murali","Gupta",105, 28, "Male","HR"));
        emp.add(new Employees("Celina","John",101, 27, "Female", "Product Development"));
        emp.add(new Employees("Prathika","Kumari",104, 27, "Female", "Account And Finance"));
        emp.add(new Employees("Rakesh","Krishna",107, 22, "Male", "HR"));
        System.out.println("Employee details before Sorting: ");
        emp.forEach(n->System.out.println(n));
        System.out.println("--------------------------------");

        System.out.println("Employee details After Sorting with firstname :");
        Collections.sort(emp,(o1,o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()));
        emp.stream().forEach(n->System.out.println(n));
        System.out.println("--------------------------------");

        Stream<Employees> data = emp.stream();
        data.forEach(n->System.out.println(n));
        System.out.println("--------------------------------");

        System.out.println("list of all first name using stream().map() :");
        emp.stream().map(employees -> employees.getFirstName()).distinct().forEach(n->System.out.println(n));
        //emp.stream().map(x ->x).distinct().forEach(y->System.out.println(y));
        //.map(x => x) the values are left untouched und you just create a copy of the original array.
        // So the strings remain strings which will break the code if numbers are expected.
        //.map(x => +x)  OR .map(x => Number(x)) OR .map(Number) converts all items in the array to a number.
        System.out.println("--------------------------------");

        System.out.println("number of male and female employees by using stream().collect() :");
        Map<String, Long> genderCount = emp.stream().collect(Collectors.groupingBy(employees -> employees.getGender(),Collectors.counting()));
        System.out.println(genderCount);
        //Collectors.averagingInt(employees -> employees.getAge()) - to find the average age of male and female employees
        System.out.println("--------------------------------");

        System.out.println("Names of employees whose Department is HR by using stream().filter():");
        emp.stream().filter(employees -> employees.getDepartment().equals("HR")).map(employees-> employees.getName()).forEach(n->System.out.println(n));
        System.out.println("--------------------------------");

        System.out.println("Count of employees in each department using stream().collect() :");
        Map<String,Long> empCountByDept = emp.stream().collect(Collectors.groupingBy(employees -> employees.getDepartment(),Collectors.counting()));
        //System.out.println(empCountByDept);
        Set<Map.Entry<String,Long>> output =  empCountByDept.entrySet();
        for(Map.Entry<String,Long> entry : output){
            System.out.println(entry.getKey() +" :" + entry.getValue());
        }
        System.out.println("--------------------------------");

        System.out.println("The average age of employees in each department using stream().collect() :");
        Map<String,Double> empAvgAgeByDept = emp.stream().collect(Collectors.groupingBy(employees -> employees.getDepartment(),Collectors.averagingInt(employees -> employees.getAge())));
        //System.out.println(empCountByDept);
        Set<Map.Entry<String,Double>> entryset =  empAvgAgeByDept.entrySet();
        for(Map.Entry<String,Double> entry : entryset){
            System.out.println(entry.getKey() +" :" + entry.getValue());
        }
        System.out.println("--------------------------------");

        System.out.println("Details of  Youngest male employee in the HR department using stream().filter() :");
        Optional<Employees> youngMaleWrapper =  emp.stream().filter(employees -> employees.getGender().equals("Male") && employees.getDepartment().equals("HR")).min(Comparator.comparingInt(employees-> employees.getAge()));
        Employees youngMale  = youngMaleWrapper.get();
        System.out.println("First Name : " +youngMale.getFirstName());
        System.out.println("Last Name : " +youngMale.getLastName());
        System.out.println("Id : " +youngMale.getEmpId());
        System.out.println("Age : " +youngMale.getAge());
        System.out.println("Gender : " +youngMale.getGender());
        System.out.println("Department Name : " +youngMale.getDepartment());
        System.out.println("--------------------------------");

        System.out.println("Sorting the employees by LastName and printing the first element in that sorted list :");
        Employees sort = emp.stream().sorted(Comparator.comparing(employees -> employees.getLastName())).findFirst().get();
        System.out.println(sort);
        System.out.println("--------------------------------");

        System.out.println("number of male and female employees in sales and Marketing Dept :");
        Map<String, Long> genderCountInDept = emp.stream().filter(employees -> employees.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(employees -> employees.getGender(),Collectors.counting()));
        System.out.println(genderCountInDept);
        //Collectors.averagingInt(employees -> employees.getAge()) - to find the average age of male and female employees
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("list of all employees in each department");
        Map<String,List<Employees>> empDetailsByDept  = emp.stream().collect(Collectors.groupingBy(employees -> employees.getDepartment()));
        Set<Map.Entry<String,List<Employees>>> empDetailsByDeptEntry = empDetailsByDept.entrySet();
        for(Map.Entry<String,List<Employees>> empDetails: empDetailsByDeptEntry){
            System.out.println("Employees in "+empDetails.getKey()+" is :");
            List<Employees> list = empDetails.getValue();
            for(Employees detail :list){
                System.out.println(detail.getName());
            }
            System.out.println("**********************************************");
        }
        System.out.println("-------------------------------------------------------------------------------------");



    }
}
