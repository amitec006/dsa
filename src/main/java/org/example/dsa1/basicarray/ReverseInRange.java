package org.example.dsa1.basicarray;

public class ReverseInRange {
    /**
     * Given an integer array A of size N and two integers B and C,
     * you have to reverse the subarray A[B:C] and return the array A.
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int B = 2;
        int C = 3;
        int[] result = new ReverseInRange().solve(A, B, C);
        for (int el : result) {
            System.out.print(el + " ");
        }
    }

    public int[] solve(int[] a, int b, int c) {
        while (b < c) {
            int temp = a[b];
            a[b] = a[c];
            a[c] = temp;
            b++;
            c--;
        }
        return a;
    }
}
