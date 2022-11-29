package com.example.entity;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.intellij.lang.annotations.Pattern;
import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.Range;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="employee_details",uniqueConstraints = { @UniqueConstraint(columnNames = { "empPhoneNum", "empEmail" })})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long empId;

    @NotNull
    @Column(name="employee_name" ,length = 20)
   // @Pattern(regex="^[a-zA-Z ]*")
    String empName;

    @NotNull
    @Column(name="employee_phonenumber" ,unique = true)
    String empPhoneNum;

    @Column(name="employee_email" , length = 40)
    //@Email(regexp = ".+@.+\\..+",message = "Invalid Email Format")
    String empEmail;

}
