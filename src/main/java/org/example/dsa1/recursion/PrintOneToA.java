package org.example.dsa1.recursion;

public class PrintOneToA {
    public static void main(String[] args) {
        new PrintOneToA().solve(5);
    }

    public void solve(int A) {
        print(A);
        System.out.println();
    }

    public void print(int A) {
        if (A == 0) {
            return;
        }
        print(A - 1);
        System.out.print(A + " ");
    }
}
