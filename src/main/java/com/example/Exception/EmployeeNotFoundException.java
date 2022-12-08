package com.example.Exception;

//own exception created if particular id is not present
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int empId){

        super("Could not find employee Id No. " +empId);
    }
}
