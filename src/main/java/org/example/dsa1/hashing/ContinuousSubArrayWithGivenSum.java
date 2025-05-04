package org.example.dsa1.hashing;

public class ContinuousSubArrayWithGivenSum {
    /**
     * Given an array of positive integers A and an integer B,
     * find and return first continuous subarray which adds to B.
     *
     * If the answer does not exist return an array with a single integer "-1".
     *
     * First sub-array means the sub-array for which starting index in minimum.
     *
     * Return the first continuous sub-array which adds to B
     * and if the answer does not exist return an array with a single integer "-1"
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(new ContinuousSubArrayWithGivenSum().solve(A, B));
    }

    public int[] solve(int[] A, int B) {
        return new int[]{-1};
    }
}
