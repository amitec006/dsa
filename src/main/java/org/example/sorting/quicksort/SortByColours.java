package org.example.sorting.quicksort;

public class SortByColours {
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2};
        sortColors(A);
        for (int el : A) {
            System.out.print(el +" ");
        }
    }

    public static void sortColors(int[] A) {
        int low = 0, mid = 0, high = A.length - 1;

        while (mid <= high) {
            if (A[mid] == 0) {
                // Swap A[mid] and A[low]
                int temp = A[low];
                A[low] = A[mid];
                A[mid] = temp;
                low++;
                mid++;
            } else if (A[mid] == 1) {
                mid++; // Keep 1 in the middle
            } else { // A[mid] == 2
                // Swap A[mid] and A[high]
                int temp = A[mid];
                A[mid] = A[high];
                A[high] = temp;
                high--;
            }
        }
    }
}
