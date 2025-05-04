package org.example.dsa1.recursion;

public class PrintDecreasingIncreasing {
    public static void main(String[] args) {
        new PrintDecreasingIncreasing().DecThenInc(5);
    }

    public void DecThenInc(int A) {
        print(A);
        System.out.println();
    }

    public void print(int A) {
        if (A == 0) {
            return;
        }
        System.out.print(A);
        print(A - 1);
        System.out.print(A);
    }
}
