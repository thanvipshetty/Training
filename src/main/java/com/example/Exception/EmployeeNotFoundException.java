package com.example.Exception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(int empId){
        super("Could not find employee Id No. " +empId);
    }
}
