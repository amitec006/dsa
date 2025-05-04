package org.example.dsa1.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(new Factorial().solve(5));
    }

    public int solve(int A) {
        if (A == 0) {
            return 1;
        }
        return A * solve(A - 1);
    }
}
