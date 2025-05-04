package org.example.dsa1.sorting;

import java.util.Arrays;

public class LargestNumber {
    /**
     * Given an array A of non-negative integers, arrange them such that they form the largest number.
     *
     * Note: The result may be very large, so you need to return a string instead of an integer.
     */

    public static void main(String[] args) {
        int[] A = {3, 30, 34, 5, 9};
        System.out.println(new LargestNumber().largestNumber(A));
    }

    public String largestNumber(int[] A) {
        // code here
        int n = A.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(A[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
