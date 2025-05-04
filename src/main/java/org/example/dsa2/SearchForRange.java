package org.example.dsa2;

public class SearchForRange {
    /**
     * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
     *
     * Return an array of size 2, such that
     *           First element = Left most index of B in A
     *           Second element = Right most index of B in A.
     * If B is not found in A, return [-1, -1].
     *
     * Note : Note: The time complexity of your algorithm must be O(log n)..
     */
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        int[] result = new SearchForRange().searchRange(A, B);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[2];
        result[0] = findFirstOccurrence(A, B);
        result[1] = findLastOccurrence(A, B);
        return result;

        //return findFirstAndLastOccurrence(A, B);
    }

    private int[] findFirstAndLastOccurrence(int[] a, int b) {
        int low = 0;
        int high = a.length - 1;
        int first = -1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == b) {
                first = mid;
                last = mid;
                // Search for the first occurrence
                int temp = mid;
                while (temp >= low && a[temp] == b) {
                    first = temp;
                    temp--;
                }
                // Search for the last occurrence
                temp = mid;
                while (temp <= high && a[temp] == b) {
                    last = temp;
                    temp++;
                }
                break;
            } else if (a[mid] < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{first, last};
    }

    private int findLastOccurrence(int[] a, int b) {
        int low = 0;
        int high = a.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == b) {
                result = mid;
                low = mid + 1;
            } else if (a[mid] < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findFirstOccurrence(int[] a, int b) {
        int low = 0;
        int high = a.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == b) {
                result = mid;
                high = mid - 1;
            } else if (a[mid] < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
