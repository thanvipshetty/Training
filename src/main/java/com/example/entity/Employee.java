package com.example.entity;


import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

@Entity
@Table(name="employee_details",uniqueConstraints = { @UniqueConstraint(columnNames = { "employee_phonenumber", "employee_email" })})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="employee_id")
    int empId;

    @NotNull
    @Column(name="employee_name")
    @Pattern(regexp="^[a-zA-Z ]*",message = "Invalid Name")
    @Size(min=2,max=20,message = "length of name should be between 2-20")
    String empName;

    @NotNull
    @Column(name="employee_phonenumber" ,unique = true)
    @Pattern(regexp="^[0-9]*")
    @Size(min = 10, max = 12, message = "Invalid PhoneNumber")
    String empPhoneNum;

    @NotNull
    @Column(name="employee_email" ,unique = true)
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email Format")
    String empEmail;

}
