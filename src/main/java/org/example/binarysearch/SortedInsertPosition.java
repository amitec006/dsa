package org.example.binarysearch;

public class SortedInsertPosition {
    /**
     * You are given a sorted array A of size N and a target value B.
     * Your task is to find the index (0-based indexing) of the target value in the array.
     *
     * If the target value is present, return its index.
     * If the target value is not found, return the index of least element greater than equal to B.
     * If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
     * Your solution should have a time complexity of O(log(N)).
     */

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 8};
        int B = 9;

        int res = new SortedInsertPosition().searchInsert(A, B);
        System.out.println(res);
    }

    public int searchInsert(int[] A, int B) {
        int low = 0;
        int high = A.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result == -1 ? A.length : result;
    }

}
