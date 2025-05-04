package org.example.dsa1.basicarray;

public class FindMajorityElement {
    /**
     * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
     * You may assume that the array is non-empty and the majority element always exists in the array.
     */

    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        System.out.println(new FindMajorityElement().majorityElement(A));
    }

    public int majorityElement(final int[] A) {
        int n = A.length;
        int count = 1;
        int majorityElement = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] == majorityElement) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityElement = A[i];
                count = 1;
            }
        }
        int freq = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == majorityElement) {
                freq++;
            }
        }
        if (freq > n / 2) {
            return majorityElement;
        }
        return -1;
    }
}
