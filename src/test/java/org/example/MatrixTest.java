package org.example;

import org.example.assign1.MatrixClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {
    @Test
    public void matrixTesting(){
        MatrixClass matrix = new MatrixClass();
        int row=2;
        int column=2;
        int[][] actual = new int[][]{new int[]{2, 4}, new int[]{4, 6}};
        assertEquals(16,matrix.addition(row,column,actual));
    }
}
