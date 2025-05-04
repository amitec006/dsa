package org.example.dsa1.recursion;

public class AllIndicesOfAnArray {
    /**
     * Given an array of integers A with N elements
     * and a target integer B, the task is to find all the indices at which B occurs in the array.
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 5, 1};
        int B = 1;
        int[] res = new AllIndicesOfAnArray().allIndices(A, B);
        for (int r : res) {
            System.out.println(r);
        }
    }

    public int[] allIndices(int[] A, int B) {
        return solve(A,B, 0, 0);
    }

    private static int[] solve (int[] A, int B, int count, int i) {
        if (i == A.length) {
            return new int[count];
        }
        if (A[i] == B) {
            int[] res = solve(A, B, count+1, i+1);
            res[count] = i;
            return res;
        } else {
            return solve(A, B, count, i+1);
        }
    }
}
