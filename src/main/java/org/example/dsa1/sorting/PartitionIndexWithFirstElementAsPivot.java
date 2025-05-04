package org.example.dsa1.sorting;

public class PartitionIndexWithFirstElementAsPivot {
    /**
     * Given an integer array A of length N, considering the last element as pivot p, rearrange the elements such that for all i:
     *
     * if A[i] < p then it should be present on left side of the partition
     * if A[i] > p then it should be present on right side of the partition
     * Rearrange the given array as well as return the partition index.
     *
     * Note: All elements are distinct
     */

    public static void main(String[] args) {
        int[] A = {3, 6, 2, 0, 4, 5};
        System.out.println(new PartitionIndexWithFirstElementAsPivot().partition(A));

        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public int partition(int[] arr) {
        // code here
        int n = arr.length;
        int pivot = arr[0];
        int i = 1;
        int j = 1;
        while (j < n) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        int temp = arr[i-1];
        arr[i-1] = arr[0];
        arr[0] = temp;
        return i;
    }
}
