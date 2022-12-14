package org.example.assign2;

import static java.util.stream.Collectors.joining;

public class Employee {
    String firstName;
    String lastName;
    int empId;
    int age;
    String gender;
    String department;

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, int empId, int age, String gender, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empId = empId;
        this.age = age;
        this.gender = gender;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmpId() {
        return empId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public String setDepartment(String department) {
        this.department = department;
        return department;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getName(){
        firstName = firstName!=null?firstName:"";
        lastName = lastName!=null?lastName:"";

        return (firstName + " "  + lastName).trim();
    }

    @Override
    public String toString() {
        return "Employees{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", empId=" + empId +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
