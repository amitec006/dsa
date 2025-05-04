package org.example.dsa2;

public class FindSmallestAgain {
    /**
     * Given an integer array A of size N.
     *
     * If we store the sum of each triplet of the array A in a new list,
     * then find the Bth smallest element among the list.
     *
     * NOTE: A triplet consists of three elements from the array.
     * Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
     *
     *
     * Explanation:
     *
     * All the triplets of the array A are:
     *
     *  (2, 4, 3) = 9
     *  (2, 4, 2) = 8
     *  (2, 3, 2) = 7
     *  (4, 3, 2) = 9
     *
     *  So the 3rd smallest element is 9.
     */
    public static void main(String[] args) {
        int[] A = {2, 4, 3, 2};
        int B = 3;

        System.out.println(new FindSmallestAgain().solve(A, B));
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int[] sum = new int[n * (n - 1) / 2];
        int index = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum[index++] = A[i] + A[j] + A[k];
                }
            }
        }
        return quickSelect(sum, 0, sum.length - 1, B);
    }

    private int quickSelect(int[] sum, int i, int i1, int b) {
        if (i == i1) {
            return sum[i];
        }
        int pivot = partition(sum, i, i1);
        if (pivot == b - 1) {
            return sum[pivot];
        } else if (pivot < b - 1) {
            return quickSelect(sum, pivot + 1, i1, b);
        } else {
            return quickSelect(sum, i, pivot - 1, b);
        }
    }

    private int partition(int[] sum, int i, int i1) {
        int pivot = sum[i1];
        int j = i;
        for (int k = i; k < i1; k++) {
            if (sum[k] < pivot) {
                int temp = sum[j];
                sum[j] = sum[k];
                sum[k] = temp;
                j++;
            }
        }
        int temp = sum[j];
        sum[j] = sum[i1];
        sum[i1] = temp;
        return j;
    }
}
