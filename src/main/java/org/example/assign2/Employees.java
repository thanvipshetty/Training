package org.example.assign2;

public class Employees {
    String firstName;
    String lastName;
    int empId;

    public Employees() {
        super();
    }


    public Employees(String firstName, String lastName, int empId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empId = empId;
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

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", empId=" + empId +
                '}';
    }

}
