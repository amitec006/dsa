package org.example.dsa2;

public class FindPeakElement {
    /**
     * Given an array of integers A, find and return the peak element in it.
     * An array element is considered a peak if it is not smaller
     * than its neighbors. For corner elements, we need to consider only one neighbor.
     *
     * NOTE:
     *
     * It is guaranteed that the array contains only a single peak element.
     * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
     */

    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        System.out.println(new FindPeakElement().solve(A));
    }

    public int solve(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] > A[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return A[low];
    }
}
