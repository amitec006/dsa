package org.example.dsa1.recursion;

public class Fibbonacci {
    public static void main(String[] args) {
        System.out.println(new Fibbonacci().findAthFibonacci(5));
    }

    public int findAthFibonacci(int A) {
        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
