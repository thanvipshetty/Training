package com.example.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data // getter ,setter , toString will be included
@AllArgsConstructor // constructor with parameter
@NoArgsConstructor //constructor with no parameter
@FieldDefaults(level = AccessLevel.PRIVATE)  //each field is private

@Entity //this class is mapped to database
@Table(name="employee_details",uniqueConstraints = { @UniqueConstraint(columnNames = { "employee_phonenumber", "employee_email" })})
public class Employee {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //auto generation in sequence
    @Column(name="employee_id") // column name in database
    int empId;

    @NotNull // should not be null
    @Column(name="employee_name")
    @Pattern(regexp="^[a-zA-Z ]*",message = "Invalid Name") // only alphabets and space is considered
    @Size(min=2,max=20,message = "length of name should be between 2-20") // length if the name that should be considered
    String empName;

    @NotNull
    @Column(name="employee_phonenumber" ,unique = true)
    @Pattern(regexp="^[0-9]*") // only numbers are considered
    @Size(min = 10, max = 12, message = "Invalid PhoneNumber")
    String empPhoneNum;

    @NotNull
    @Column(name="employee_email" ,unique = true)
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email Format")
    String empEmail;

}
