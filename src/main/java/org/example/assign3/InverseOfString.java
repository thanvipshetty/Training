package org.example.assign3;

import java.util.Scanner;

public class InverseOfString {
    public static void main(String[] args) {
        System.out.println("enter the string :");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuilder input2 = new StringBuilder(str);
        input2.reverse();
        System.out.println("Reversed String is :");
        System.out.println(input2);
    }
}
