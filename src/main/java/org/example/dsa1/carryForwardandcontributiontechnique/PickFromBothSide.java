package org.example.dsa1.carryForwardandcontributiontechnique;

public class PickFromBothSide {

    /**
     * You are given an integer array A of size N.
     *
     * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
     *
     * Find and return the maximum possible sum of the B elements that were removed after the B operations.
     *
     * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
     *
     * Remove 3 elements from front and 0 elements from the back, OR
     * Remove 2 elements from front and 1 element from the back, OR
     * Remove 1 element from front and 2 elements from the back, OR
     * Remove 0 elements from front and 3 elements from the back.
     *
     * Input 1:
     *  A = [5, -2, 3 , 1, 2]
     *  B = 3
     * Input 2:
     *
     *  A = [ 2, 3, -1, 4, 2, 1 ]
     *  B = 4
     * Example Output
     *
     * Output 1:
     *  8
     * Output 2:
     *  9
     */


    public static void main(String[] args) {
        int[] A = { 2, 3, -1, 4, 2, 1 };
        int B = 4;

        System.out.println(new PickFromBothSide().solve(A, B));
    }
    public int solve(int[] A, int B) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[n-1-i];
        }

        int temp = sum;
        for (int i = 0; i < B; i++) {
            temp = temp - A[n-B+i] + A[i];
            if (temp > sum) {
                sum = temp;
            }
        }
        return sum;
    }
}
