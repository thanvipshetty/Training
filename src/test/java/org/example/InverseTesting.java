package org.example;

import org.example.assign3.InverseOfString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InverseTesting {
    @Test
    public void inverseTesting(){
        InverseOfString inverseString = new InverseOfString();
        assertEquals("olleH",  inverseString.reverse("Hello"));
    }
}
