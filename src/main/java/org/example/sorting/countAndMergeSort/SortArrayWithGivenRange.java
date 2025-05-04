package org.example.sorting.countAndMergeSort;

import java.util.ArrayList;
import java.util.List;

public class SortArrayWithGivenRange {
    public static void main(String[] args) {
        int[] A = {59, 11, 8, 91, 49, 44, 8}; //[59, 11, 8, 91, 8, 44, 49]
        int B = 4;
        int C = 6;

        int[] res = new SortArrayWithGivenRange().mergeSort(A, B, C);
        for(int el:res) {
            System.out.print(el + " ");
        }
    }

    public int[] mergeSort(int[] A, int B, int C) {
        if (B < C) {
            int mid = B + (C - B) / 2;

            // Recursively sort left half
            mergeSort(A, B, mid);
            // Recursively sort right half
            mergeSort(A, mid + 1, C);

            // Merge sorted halves
            merge(A, B, mid, C);
        }
        return A;
    }


    public void merge (int[] A, int B, int mid, int C) {
        List<Integer> list = new ArrayList<>();
        int i = B;
        int j = mid+1;
        while (i <= mid && j <= C) {
            if (A[i] <= A[j]) {
                list.add(A[i++]);
            } else {
                list.add(A[j++]);
            }
        }

        while (i <= mid) list.add(A[i++]);
        while (j <= C) list.add(A[j++]);

        for (int in = B; in <= C; in++) {
            A[in] = list.get(in - B);
        }
    }


}

