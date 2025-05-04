package org.example.sorting.countAndMergeSort;

public class CreateSmallestNumberWithGivenArray {
    /**
     * An integer is given to you in the form of an array, with each element being a separate digit.
     *
     * Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the digits of the given number in an array. Return the smallest number in the form an array.
     *
     * Note - Do not use any sorting algorithm or library's sort method.
     */

    public static void main(String[] args) {
        int[] A = {6, 3, 4, 2, 7, 2, 1, 1, 0, 2};
        int[] res = new CreateSmallestNumberWithGivenArray().smallestNumber(A);
        for (int el : res) {
            System.out.print(el +" ");
        }
    }

    public int[] smallestNumber(int[] A) {
        int[] arr = new int[10];
        for (int el : A) {
            arr[el] += 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            while (e > 0) {
                A[count] = i;
                e--;
                count++;
            }
        }
        return A;
    }

}
