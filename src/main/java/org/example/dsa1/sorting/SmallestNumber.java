package org.example.dsa1.sorting;

public class SmallestNumber {
    /**
     * An integer is given to you in the form of an array, with each element being a separate digit.
     *
     * Find the smallest number (leading zeroes are allowed)
     * that can be formed by rearranging the digits of the given number in an array.
     * Return the smallest number in the form an array.
     *
     * Note - Do not use any sorting algorithm or library's sort method.
     */

    public static void main(String[] args) {
        int[] A = {4,8,6,8};
        int[] result = new SmallestNumber().smallestNumber(A);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] smallestNumber(int[] A) {
        int min = A[0];
        int max = A[0];
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int[] count = new int[max - min + 1];
        for (int i : A) {
            count[i-min]++;
        }
        int pos = 0;
        for (int i = 0; i < count.length; i++) {
            int k = count[i];
            while (k > 0) {
                A[pos] = i + min;
                k--;
                pos++;
            }
        }
        return A;
    }
}
