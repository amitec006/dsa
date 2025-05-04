package org.example.binarysearch;

public class SingleElementInSortedArray {
    /**
     * Given a sorted array of integers A where every element appears
     * twice except for one element which appears once,
     * find and return this single element that appears only once.
     *
     * Elements which are appearing twice are adjacent to each other.
     *
     * NOTE: Users are expected to solve this in O(log(N)) time.
     */

    public static void main(String[] args) {
        int[] A = {1, 1, 7, 3, 3, 5, 5};
        int res = new SingleElementInSortedArray().solve(A);
        System.out.println(res);
    }

    public int solve(int[] A) {
        int low = 0;
        int high = A.length - 1;
        if (high ==0) return A[0];
        if (A[0] != A[1]) return A[0];
        if (A[high] != A[high-1]) return A[high];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]){
                return A[mid];
            } else if ((A[mid] == A[mid-1] && mid%2 == 1)
                    || (A[mid] == A[mid+1] && mid%2 == 0)) {
                low = mid +1;
            } else {
                high = mid -1;
            }

        }
        return -1;
    }
}
