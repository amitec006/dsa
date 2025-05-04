package org.example.dsa1.sorting;

import java.util.Arrays;

public class WaveArray {
    /**
     * Given an array of integers A, sort the array into a wave-like array and return it.
     * In other words, arrange the elements into a sequence such that
     *
     * a1 >= a2 <= a3 >= a4 <= a5.....
     * NOTE: If multiple answers are possible, return the lexicographically smallest one.
     */

    public static void main(String[] args) {
        int[] A = {6,17,15,13};
        int[] result = new WaveArray().wave(A);  //O(N) = NlogN
        result = new WaveArray().sortInWave(A, A.length); //O(N) = N

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] wave(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        // Swap adjacent elements
        for (int i=0; i<n-1; i += 2)
            swap(A, i, i+1);
        return A;
    }

    // This function sorts arr[0..n-1] in wave form, i.e.,
    // arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]....
    public int[]  sortInWave(int arr[], int n)
    {
        // Traverse all even elements
        for(int i = 0; i < n-1; i+=2){
            //swap odd and even positions
            if(i > 0 && arr[i - 1] > arr[i])
                swap(arr, i, i-1);
            if(i < n-1 && arr[i + 1] > arr[i])
                swap(arr, i, i+1);
        }
        return arr;
    }

    private void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }
}
