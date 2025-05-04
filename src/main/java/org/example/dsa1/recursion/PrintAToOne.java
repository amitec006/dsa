package org.example.dsa1.recursion;

public class PrintAToOne {
    public static void main(String[] args) {
        new PrintAToOne().solve(5);
    }

    public void solve(int A) {
        print(A);
        System.out.println();
    }

    public void print(int A) {
        if (A == 0) {
            return;
        }
        System.out.print(A + " ");
        print(A - 1);
    }
}
