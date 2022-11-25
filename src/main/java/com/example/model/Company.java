package com.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;


@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

@Component
public class Company {

    int companyId;
    String companyName;
    String companyLocation;

}
