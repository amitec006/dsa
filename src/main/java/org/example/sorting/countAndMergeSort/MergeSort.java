package org.example.sorting.countAndMergeSort;

import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low +1];
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//
        int count = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[count] = (arr[left]);
                left++;
            } else {
                temp[count] = (arr[right]);
                right++;
            }
            count++;
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp[count] = (arr[left]);
            left++;
            count++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp[count] = (arr[right]);
            right++;
            count++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high-low) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }

}
