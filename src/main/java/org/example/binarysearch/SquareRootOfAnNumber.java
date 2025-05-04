package org.example.binarysearch;

public class SquareRootOfAnNumber {

    /**
     * Given an integer A. Compute and return the square root of A.
     * If A is not a perfect square, return floor(sqrt(A)).
     *
     * NOTE:
     *    The value of A*A can cross the range of Integer.
     *    Do not use the sqrt function from the standard library.
     *    Users are expected to solve this in O(log(A)) time.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new SquareRootOfAnNumber().sqrt(930675566));
    }

    public int sqrt(int A) {
        int l = 1;
        int h = A/2==0?A:A/2;
        int ans = 0;
        while (l <= h) {
            int mid = l + (h-l)/2;
            long square = (long)mid*mid;
            if(square == A){
                return mid;
            } else if (square < A) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }
}
