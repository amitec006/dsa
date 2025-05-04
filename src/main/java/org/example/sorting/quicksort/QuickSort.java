package org.example.sorting.quicksort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] A =  {1, 4, 10, 2, 1, 5};
        int[] res = new QuickSort().sort(A, 0, A.length-1);
        for (int el : res) {
            System.out.print(el+" ");
        }
    }

    private int[] sort(int[] A, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(A, low, high);
            sort(A, low, partitionIndex - 1);
            sort(A, partitionIndex + 1, high);
        }
        return A;
    }

    private int partition(int[] A, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int tmp = A[pivotIndex];
        A[pivotIndex] = A[low];
        A[low] = tmp;
        int pivot = A[low];
        int i = low+1;
        int j = high;

        while (i <= j) {
            if (A[i] <= pivot) {
                i++;
            } else if (A[j] >= pivot) {
                j--;
            } else {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
        A[low] = A[j];
        A[j] = pivot;
        return j;
    }
}
