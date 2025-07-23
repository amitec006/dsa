package org.example.dsa1.prefixsum;

public class EquilibriumIndex {
    /**
     * You are given an array A of integers of size N.
     *
     * Your task is to find the equilibrium index of the given array
     *
     * The equilibrium index of an array is an index such that
     * the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
     *
     * If there are no elements that are at lower indexes or
     * at higher indexes, then the corresponding sum of elements is considered as 0.
     *
     * Note:
     *
     * Array indexing starts from 0.
     * If there is no equilibrium index then return -1.
     * If there are more than one equilibrium indexes then return the minimum index.
     */
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        //System.out.println(equilibriumIndex(arr));
        System.out.println(equilibriumIndexApproach2(arr));
    }

    //Approach 1
    private static int equilibriumIndex(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    //Approach 2
    private static int equilibriumIndexApproach2(int[] arr) {
        int n = arr.length;
        int[] pf = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pf[i] = arr[i];
            } else {
                pf[i] = pf[i-1] + arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            if (i != 0) {
                leftSum = pf[i-1];
            }
            int rightSum = 0;
            if (i != n-1) {
                rightSum = pf[n-1] - pf[i];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int solve(int[] A) {
        long[] ps = new long[A.length];
        for (int i= 0; i < A.length; i++) {
            if (i == 0) {
                ps[i] = A[i];
            } else {
                ps[i] = ps[i-1] + A[i];
            }
        }

        int index = 1;
        //if index 0 is equilibrium index
        if ((ps[ps.length-1] - ps[0]) == 0) return 0;

        for (int i = 1; i < ps.length; i++) {
            if (ps[index-1] == (ps[ps.length-1] - ps[index])) {return index;}
            index++;
        }
        return -1;
    }
}
