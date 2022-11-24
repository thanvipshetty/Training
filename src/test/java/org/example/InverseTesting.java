package org.example;

import org.example.assign3.InverseOfString;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class InverseTesting {
    @Test
    public void inverseTesting(){
        InverseOfString inverseString = new InverseOfString();
        assertEquals("olleH",  inverseString.reverse("Hello"));
    }
}
