package org.example.sorting.countAndMergeSort;


import java.util.ArrayList;
import java.util.List;

public class InversionCount {

    public static void main(String[] args) {
        int arr[] = { 3, 5, 2, 4, 1 };
        System.out.println(mergeSort(arr, 0, arr.length-1));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high-low) / 2 ;
        int cutoff = (int) (Math.pow(10,9)+7);
        int inversionCount = 0;
        inversionCount = (inversionCount + mergeSort(arr, low, mid))%cutoff;  // left half
        inversionCount = (inversionCount + mergeSort(arr, mid + 1, high))%cutoff; // right half
        inversionCount = (inversionCount + merge(arr, low, mid, high))%cutoff;  // merging sorted halves
        return inversionCount%cutoff;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>();
        int i = left;
        int j = mid+1;
        int inversionCount = 0;
        int cutoff = (int) (Math.pow(10,9)+7);
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
                inversionCount = (inversionCount + (mid - i + 1))%cutoff;
            }
        }

        while (i <= mid) temp.add(arr[i++]);
        while (j <= right) temp.add(arr[j++]);

        // transfering all elements from temporary to arr //
        for (int in = left; in <= right; in++) {
            arr[in] = temp.get(in - left);
        }
        return inversionCount;
    }
}
