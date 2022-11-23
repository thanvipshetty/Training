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
        System.out.println("Enter the elements of  matrix");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                a[i][j] = in.nextInt();
            }
        }
        addition(row,column,a);
    }
    public static int addition(int row, int column, int a[][]){
        System.out.println("Sum of the given  matrix is :\n");
         int sum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++) {
                sum = sum + a[i][j];
            }
        }
        return sum;
    }

}
