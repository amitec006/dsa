package org.example.dsa2;

public class SingleElementInSortedArray {
    /**
     * Given a sorted array of integers A
     * where every element appears twice except for
     * one element which appears once, find
     * and return this single element that appears only once.
     *
     * Elements which are appearing twice are adjacent to each other.
     *
     * NOTE: Users are expected to solve this in O(log(N)) time.
     */

    public static void main(String[] args) {
        int[] A = {1, 1, 7, 7, 9};
        System.out.println(new SingleElementInSortedArray().solve(A));
    }

    public int solve(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 0) {
                if (A[mid] == A[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid;
                }
            } else {
                if (A[mid] == A[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return low == A.length?-1:A[low];
    }
}
