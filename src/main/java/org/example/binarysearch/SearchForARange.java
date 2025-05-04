package org.example.binarysearch;

public class SearchForARange {
    /**
     * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
     *
     * Return an array of size 2, such that
     *           First element = Left most index of B in A
     *           Second element = Right most index of B in A.
     * If B is not found in A, return [-1, -1].
     *
     * Note : Note: The time complexity of your algorithm must be O(log n)
     */
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;

        int[] ans = searchRange(A, B);

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] searchRange(int[] a, int b) {
        int[] ans = new int[2];
        ans[0] = findFirstOccurrence(a, b);
        ans[1] = findLastOccurrence(a, b);
        return ans;
    }

    private static int findLastOccurrence(int[] a, int b) {
        int low = 0;
        int high = a.length-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (a[mid] == b) {
                ans = mid;
                low = mid + 1;
            }

            if (a[mid] > b) {
                high = mid - 1;
            }
            if (a[mid] < b) {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findFirstOccurrence(int[] a, int b) {
        int low = 0;
        int high = a.length-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (a[mid] == b) {
                ans = mid;
                high = mid - 1;
            }

            if (a[mid] > b) {
                high = mid - 1;
            }
            if (a[mid] < b) {
                low = mid + 1;
            }
        }
        return ans;
    }
}
