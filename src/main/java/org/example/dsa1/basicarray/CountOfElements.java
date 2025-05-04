package org.example.dsa1.basicarray;

public class CountOfElements {
    /**
     * Given an array A of N integers.
     * Count the number of elements that have at
     * least 1 elements greater than itself.
     */
    public static void main(String[] args) {
        int[] A = {3, 4, 5, 1, 2, 5};
        System.out.println(new CountOfElements().solve(A));
    }

    public int solve(int[] arr) {
        // Find the maximum number
        int count = 1;
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                count = 1;
            }
            else if(arr[i] == max) {
                count++;
            }
        }
        int ans = arr.length - count;
        return ans;
    }
}
