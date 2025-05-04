package org.example.sorting.quicksort;

public class Sort01 {
    public static void main(String[] args) {
       // Given an array A of 0s and 1s of length N. Sort this array.
       // Note - Do not use any sorting algorithm or library's sort method.
        int[] A = {0,0,1,0,1,1,0};
        int[] res = new Sort01().sort01(A);
        for (int el : res) {
            System.out.print(el + " ");
        }
    }

    public int[] sort01(int[] A) {
        int i = 0;
        int j = A.length-1;
        while (i < j) {
            if (A[i] == 0) {
                i++;
            } else if (A[j] == 1) {
                j--;
            } else {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
        return A;
    }

}
