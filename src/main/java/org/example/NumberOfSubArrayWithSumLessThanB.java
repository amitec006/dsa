package org.example;

public class NumberOfSubArrayWithSumLessThanB {
    /**
     * Given an array A of N non-negative numbers and a non-negative number B,
     * you need to find the number of subarrays in A with a sum less than B.
     * We may assume that there is no overflow.
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 15};
        int B = 10;
        System.out.println(new NumberOfSubArrayWithSumLessThanB().solve(A, B));


    }

    //For each valid window, the number of subarrays ending at end and starting anywhere from start to end is (end - start + 1).
    public int solve(int[] A, int B){
        int n = A.length;
        int count = 0;
        int sum = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            sum += A[i];
            while(sum >= B){
                sum -= A[j];
                j++;
            }
            count += (i - j + 1);
        }
        return count;
    }
}

