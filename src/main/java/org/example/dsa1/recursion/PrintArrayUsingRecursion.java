package org.example.dsa1.recursion;

public class PrintArrayUsingRecursion {

    /**
     * You are given an array A. Print the elements of the array using recursion.
     */

    public static void main(String[] args) {
        int[] A = {6, -2, 5, 3};
        new PrintArrayUsingRecursion().PrintArray(A);
    }

    public void PrintArray(int[] A) {
        print(A, 0);
    }

    private void print(int[] A, int i) {
        if (i >= A.length) {
            return;
        }
        System.out.print(A[i] +" ");
        print(A , i+1);
        System.out.println();
    }
}

