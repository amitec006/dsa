package org.example.dsa1.sorting;

public class PartitionIndexWithLastElementAsPivot {
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
        int[] A = {6, 2, 7, 0, 1, 3, 9, 4, 5};
        System.out.println(new PartitionIndexWithLastElementAsPivot().partition2(A, 0, A.length-1));

        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    private int partition2(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;
        while (j < high) {
            if (arr[j] > pivot) {
                j++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        swap(arr, i, j);
        return i;
    }

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr) {
        // code here
        int n = arr.length;
        int pivot = arr[n-1];
        int i = 0;
        for (int j = 0; j < n-1; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[n-1];
        arr[n-1] = temp;
        return i+1;
    }
}
