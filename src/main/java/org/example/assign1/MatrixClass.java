//Implement a program to print sum of 2*2 matrix
package org.example.assign1;

import java.util.Scanner;

public class MatrixClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int  row = in.nextInt();
        System.out.println("Enter the number of columns");
        int column = in.nextInt();
        int[][] a = new int[row][column];
        int[][] b = new int[row][column];
        int[][] c= new int[row][column];
        System.out.println("Enter the elements of 1st matrix");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                a[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter the elements of 2nd matrix");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                b[i][j] = in.nextInt();
            }
        }
        System.out.println("Sum of the given two matrix is :\n");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j]+"\t");
            }
            System.out.println("\n");
        }


    }
}
