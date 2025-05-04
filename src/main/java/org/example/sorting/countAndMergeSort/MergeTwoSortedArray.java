package org.example.sorting.countAndMergeSort;

import javax.sound.midi.Soundbank;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] A = {4, 7, 9, 13, 17, 21};
        int[] B = {2, 11, 19};

        int[] res = mergeTwoSortedArray(A, B);

        for (int el:res){
            System.out.print(el+ " ");
        }

    }

    private static int[] mergeTwoSortedArray(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];

        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        while (aIndex < A.length && bIndex < B.length) {
            if (A[aIndex] <= B[bIndex]) {
                res[index] = A[aIndex];
                aIndex++;
            } else {
                res[index] = B[bIndex];
                bIndex++;
            }
            index++;
        }

        while (aIndex < A.length) {
            res[index] = A[aIndex];
            aIndex++;
            index++;
        }

        while (bIndex < B.length) {
            res[index] = B[bIndex];
            bIndex++;
            index++;
        }
        return res;
    }
}
