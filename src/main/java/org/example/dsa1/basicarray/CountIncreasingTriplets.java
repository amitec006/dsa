package org.example.dsa1.basicarray;

public class CountIncreasingTriplets {
    /**
     * You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3};
        System.out.println(new CountIncreasingTriplets().solve(A));
    }

    public int solve(int[] A) {
        int n = A.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = 0;
            int rightCount = 0;
            int left = i - 1;
            int right = i + 1;

            // Count elements on the left that are smaller than A[i]
            while (left >= 0) {
                if (A[left] < A[i]) {
                    leftCount++;
                }
                left--;
            }

            // Count elements on the right that are greater than A[i]
            while (right < n) {
                if (A[right] > A[i]) {
                    rightCount++;
                }
                right++;
            }

            // Multiply leftCount and rightCount to get the triplets count for A[i]
            count += leftCount * rightCount;
        }

        return count;
    }
}
