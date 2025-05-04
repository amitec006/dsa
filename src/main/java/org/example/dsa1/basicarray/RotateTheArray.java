package org.example.dsa1.basicarray;

public class RotateTheArray {
    /**
     * Given an integer array A of size N and an integer B,
     * you have to return the same array after rotating it
     * B times towards the right.
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int B = 2;
        //op [3, 4, 1, 2]
        int[] result = new RotateTheArray().solve(A, B);
        for (int el : result) {
            System.out.print(el + " ");
        }
    }

    public int[] solve(int[] a, int b) {
        b = b % a.length;
        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }

        l = 0;
        r = b - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }

        l = b;
        r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
        return a;
    }
}
