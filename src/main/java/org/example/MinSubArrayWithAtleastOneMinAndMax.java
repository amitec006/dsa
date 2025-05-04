package org.example;

public class MinSubArrayWithAtleastOneMinAndMax {
    public static void main(String[] args) {
        int[] A = {2, 6, 1, 1, 9};

        int min = A[0];
        int max = A[0];

        for (int el : A) {
            if (el < min) {
                min = el;
            }
            if (el > max) {
                max = el;
            }
        }

        int minSubArrayLength = Integer.MAX_VALUE;
        int min_index = -1;
        int max_index = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                min_index = i;
            }
            if (A[i] == max) {
                max_index = i;
            }
            if (min_index != -1 && max_index != -1) {
                minSubArrayLength = Math.min(minSubArrayLength, Math.abs(max_index - min_index) + 1);
            }
        }
        System.out.println(minSubArrayLength);
    }
}
